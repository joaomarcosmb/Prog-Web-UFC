package org.progweb.lista02;

import org.progweb.lista02.model.product.Product;
import org.progweb.lista02.model.product.ProductDAO;
import org.progweb.lista02.model.sku.Sku;
import org.progweb.lista02.model.sku.SkuDAO;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        SkuDAO skuDAO = new SkuDAO();

        String codigoTeste = "teste-" + System.currentTimeMillis();

        System.out.println("----------------- CRUD -----------------");

        Product album = new Product();
        album.setSchema("{\"tipo\":\"álbum\",\"nome\":\"Álbum de Figurinhas da Copa do Mundo 2026\",\"idioma\":\"en\",\"codigoTeste\":\"" + codigoTeste + "-album\"}");

        Product figurinhas = new Product();
        figurinhas.setSchema("{\"tipo\":\"figurinhas\",\"nome\":\"Figurinhas da Copa do Mundo 2026\",\"idioma\":\"en\",\"codigoTeste\":\"" + codigoTeste + "-figurinhas\"}");

        System.out.println("Criação de álbum: " + productDAO.create(album));
        System.out.println("Criação de figurinha: " + productDAO.create(figurinhas));

        List<Product> produtos = productDAO.listAll();
        printProducts("Listagem de todos os produtos", produtos);

        Product albumDb = findLatestProductByMarker(produtos, codigoTeste + "-album");
        Product figurinhasDb = findLatestProductByMarker(produtos, codigoTeste + "-figurinhas");

        if (albumDb == null || figurinhasDb == null) {
            System.out.println("Não foi possível localizar os produtos de teste no banco.");
            return;
        }

        System.out.println("Pesquisa de álbum por ID: " + productDAO.getById(albumDb.getId()).getSchema());

        albumDb.setSchema("{\"tipo\":\"álbum\",\"nome\":\"Álbum de Figurinhas da Copa do Mundo 2026 - Capa Dura\",\"codigoTeste\":\"" + codigoTeste + "-album\"}");
        System.out.println("Atualização de álbum: " + productDAO.update(albumDb));

        Sku skuAlbum = new Sku();
        skuAlbum.setProductId(albumDb.getId());
        skuAlbum.setName("Álbum Oficial Copa do Mundo 2026 - Capa Cartão");
        skuAlbum.setPrice(new BigDecimal("39.90"));
        skuAlbum.setPhoto("https://ggpel.cdn.magazord.com.br/img/2026/03/produto/71029/image-2026-03-05t174914-904.png?ims=fit-in/600x600/filters:fill(white)");
        skuAlbum.setStock(120);
        skuAlbum.setDescription("Álbum oficial (pt-BR), versão capa cartão. " + codigoTeste);
        skuAlbum.setAttributes("{\"idioma\":\"pt-BR\",\"formato\":\"álbum\",\"acabamento\":\"capa-cartão\"}");

        Sku skuFigurinhas = new Sku();
        skuFigurinhas.setProductId(figurinhasDb.getId());
        skuFigurinhas.setName("Pacote com 5 Figurinhas - Copa do Mundo 2026");
        skuFigurinhas.setPrice(new BigDecimal("6.50"));
        skuFigurinhas.setPhoto("https://down-br.img.susercontent.com/file/br-11134207-7qukw-li0urvrlhzzrde");
        skuFigurinhas.setStock(800);
        skuFigurinhas.setDescription("Pacote lacrado com 5 figurinhas em português (pt-BR). " + codigoTeste);
        skuFigurinhas.setAttributes("{\"idioma\":\"pt-BR\",\"quantidade\":5,\"categoria\":\"figurinhas\"}");

        System.out.println("Criação de SKU de álbum: " + skuDAO.create(skuAlbum));
        System.out.println("Criação de SKU de figurinhas: " + skuDAO.create(skuFigurinhas));

        List<Sku> skus = skuDAO.listAll();
        printSkus("Listagem de todos os SKUs", skus);

        Sku skuAlbumDb = findLatestSkuByMarker(skus, codigoTeste, albumDb.getId());
        Sku skuFigurinhasDb = findLatestSkuByMarker(skus, codigoTeste, figurinhasDb.getId());

        if (skuAlbumDb == null || skuFigurinhasDb == null) {
            System.out.println("Não foi possível localizar os SKUs de teste no banco.");
            return;
        }

        Sku skuById = skuDAO.getById(skuAlbumDb.getId());
        System.out.println("Pesquisa de SKU de álbum por ID: " + (skuById != null ? skuById.getName() : "null"));

        skuAlbumDb.setPrice(new BigDecimal("44.90"));
        skuAlbumDb.setStock(95);
        skuAlbumDb.setDescription("Álbum oficial em português (pt-BR), estoque e preço atualizados. " + codigoTeste);
        System.out.println("Atualização de SKU de álbum: " + skuDAO.update(skuAlbumDb));

        printSkus("Pesquisa de SKU de álbum por ID", skuDAO.listByProductId(albumDb.getId()));
        printSkus("Pesquisa de SKU de figurinhas por ID", skuDAO.listByProductId(figurinhasDb.getId()));

        System.out.println("Remoção de SKU de álbum: " + skuDAO.delete(skuAlbumDb.getId()));
        System.out.println("Remoção de SKU de figurinhas: " + skuDAO.delete(skuFigurinhasDb.getId()));

        System.out.println("Remoção de álbum: " + productDAO.delete(albumDb.getId()));
        System.out.println("Remoção de figurinhas: " + productDAO.delete(figurinhasDb.getId()));

        printProducts("Listagem de todos os produtos (após limpeza)", productDAO.listAll());
        printSkus("Listagem de todos os SKUs (após limpeza)", skuDAO.listAll());
    }

    private static Product findLatestProductByMarker(List<Product> products, String marker) {
        if (products == null) {
            return null;
        }

        return products.stream()
                .filter(product -> product.getSchema() != null && product.getSchema().contains(marker))
                .max(Comparator.comparingInt(Product::getId))
                .orElse(null);
    }

    private static Sku findLatestSkuByMarker(List<Sku> skus, String marker, int productId) {
        if (skus == null) {
            return null;
        }

        return skus.stream()
                .filter(sku -> sku.getDescription() != null && sku.getDescription().contains(marker))
                .filter(sku -> sku.getProductId() == productId)
                .max(Comparator.comparingInt(Sku::getId))
                .orElse(null);
    }

    private static void printProducts(String title, List<Product> products) {
        System.out.println("\n-- " + title + " --");
        if (products == null) {
            System.out.println("null");
            return;
        }

        for (Product product : products) {
            System.out.println("Product{id=" + product.getId() + ", schema=" + product.getSchema() + "}");
        }
    }

    private static void printSkus(String title, List<Sku> skus) {
        System.out.println("\n-- " + title + " --");
        if (skus == null) {
            System.out.println("null");
            return;
        }

        for (Sku sku : skus) {
            System.out.println("Sku{id=" + sku.getId()
                    + ", productId=" + sku.getProductId()
                    + ", name=" + sku.getName()
                    + ", price=" + sku.getPrice()
                    + ", stock=" + sku.getStock()
                    + "}");
        }
    }
}
