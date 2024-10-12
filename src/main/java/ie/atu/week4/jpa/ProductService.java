package ie.atu.week4.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> add(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setProductName(updatedProduct.getProductName());
            productToUpdate.setProductDescription(updatedProduct.getProductDescription());
            productToUpdate.setProductPrice(updatedProduct.getProductPrice());
            return productRepository.save(productToUpdate);
        }
        return null;
    }

    public List<Product> deleteProduct(Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            productRepository.delete(existingProduct.get());
            return productRepository.findAll();
        }
        return null;
    }
}
