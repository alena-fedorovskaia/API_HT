package org.example.entities;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@Data
@Accessors(chain = true)
public class Pet {
    private int id;
    private String name;
    private String[] photoUrls;
    private String[] tags;
    private String status;
}
