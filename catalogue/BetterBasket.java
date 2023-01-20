package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Zakariaa Hmamou 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable {
    private static final long serialVersionUID = 1;

    @Override
    public boolean add(Product pr) {
        // Check if the product is already in the basket
        for (Product product : this) {
            if (product.getProductNum().equals(pr.getProductNum())) {
                // If so, increment the quantity
                product.setQuantity(product.getQuantity() + pr.getQuantity());
                // Sort the products by product number
                Collections.sort(this, Comparator.comparing(Product::getProductNum));
                return true;
            }
        }
        // If the product is not in the basket, add it
        super.add(pr);
        // Sort the products by product number
        Collections.sort(this, Comparator.comparing(Product::getProductNum));
        return true;
    }
}
