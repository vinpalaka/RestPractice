package spring_app.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String name;

    private Long updatedBy;
}
