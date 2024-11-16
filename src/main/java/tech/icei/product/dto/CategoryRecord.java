package tech.icei.product.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class CategoryRecord {
    private String uuid;
    private String name;
    private String description;
    private String status;
}
