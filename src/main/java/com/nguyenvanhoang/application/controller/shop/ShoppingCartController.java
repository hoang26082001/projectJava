package com.nguyenvanhoang.application.controller.shop;


import com.nguyenvanhoang.application.entity.CartItem;
import com.nguyenvanhoang.application.entity.Product;
import com.nguyenvanhoang.application.repository.ProductRepository;
import com.nguyenvanhoang.application.service.ProductService;
import com.nguyenvanhoang.application.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;

    @Autowired
    ShoppingCartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("views")
    public String viewsCarts(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("CART_ITEMS", cartService.getAllItems());
        session.setAttribute("TOTAL", cartService.getAmount());
        return "shop/cart-item";
    }

    @GetMapping("add")
    public String addCart(@RequestParam String id, @RequestParam int size){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
                CartItem item = new CartItem();

                item.setProductId(product.get().getId());
                item.setName(product.get().getName());
                item.setPrice(product.get().getPrice());
                item.setSize(size);
                item.setImage(product.get().getImages().get(0));
                item.setQty(1);
                cartService.add(item);

            }
            return "redirect:/shopping-cart/views";
    }

    @GetMapping("clear")
    public String clearCart(){
        cartService.clear();
        return "redirect:/shopping-cart/views";
    }

    @GetMapping("del/{id}/{size}")
    public String removeCartItem(@PathVariable String id, @PathVariable int size) {
        cartService.remove(id, size);
        return "redirect:/shopping-cart/views";
    }


    @GetMapping("payment-cart")
    public String paymentCart(){
        return "shop/payment_cart";
    }
}
