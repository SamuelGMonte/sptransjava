package com.sptrans.BuSearcher.model;

import lombok.Data;
import java.util.List;

@Data
public class Posicao {
    private String hr;
    private List<Veiculo> vs;

    @Data
    public static class Veiculo {
        private int p;
        private boolean a;
        private String ta;
        private double py;
        private double px;
    }
}