package com.example.dto;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Merch {

    private String merchId;

    private String merchName;

    private BigDecimal merchPrice;

    private int merchInventory;

    public Merch(String merchId) {
        this.merchId = merchId;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.merchId);
        hash = 97 * hash + Objects.hashCode(this.merchName);
        hash = 97 * hash + Objects.hashCode(this.merchPrice);
        hash = 97 * hash + this.merchInventory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Merch other = (Merch) obj;
        if (this.merchInventory != other.merchInventory) {
            return false;
        }
        if (!Objects.equals(this.merchId, other.merchId)) {
            return false;
        }
        if (!Objects.equals(this.merchName, other.merchName)) {
            return false;
        }
        if (!Objects.equals(this.merchPrice, other.merchPrice)) {
            return false;
        }
        return true;
    }

}
