package com.example.windows.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @JoinColumn(name = "brand_id")
    @ManyToOne
    private Brand brand;

    @NonNull
    @JoinColumn(name = "type_id")
    @ManyToOne
    private WindowType type;

    @NonNull
    @JoinColumn(name = "opening_type_id")
    @ManyToOne
    private OpeningType openingType;

    @NonNull
    private int width;

    @NonNull
    private int height;

    @NonNull
    private boolean hasChildLock;

    @NonNull
    @JoinColumn(name = "color_id")
    @ManyToOne
    private Color color;

    @NonNull
    @JoinColumn(name = "material_id")
    @ManyToOne
    private Material material;

    @NonNull
    @JoinColumn(name = "glazing_type_id")
    @ManyToOne
    private GlazingType glazingType;

    @NonNull
    @Column(name = "years_guaranteed")
    private Long yearsGuaranteed;
}
