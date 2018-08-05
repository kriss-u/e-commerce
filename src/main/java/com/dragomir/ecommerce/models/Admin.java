package com.dragomir.ecommerce.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
    public Admin() {
    }

    public Admin(@NotNull @Size(max = 40) String username, String password, @Email @NotNull @Size(max = 40) String email, @NotNull String firstName, String middleName, @NotNull String lastName, @NotNull String phoneNumber1, String phoneNumber2, @NotNull String address1, String address2, List<Cart> carts, List<UserOrder> userOrders) {
        super(username, password, email, firstName, middleName, lastName, phoneNumber1, phoneNumber2, address1, address2, carts, userOrders);
    }
}
