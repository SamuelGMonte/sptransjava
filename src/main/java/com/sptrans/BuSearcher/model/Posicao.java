package com.sptrans.BuSearcher.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Posicao {
    private String hr;
    private List<LinhaInfo> l;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class LinhaInfo {
        private String c;
        private int cl;
        private int sl;
        private String lt0;
        private String lt1;
        private int qv;
        private List<VeiculoStatus> vs;

        @JsonCreator
        public LinhaInfo(
                @JsonProperty("c") String c,
                @JsonProperty("cl") int cl,
                @JsonProperty("sl") int sl,
                @JsonProperty("lt0") String lt0,
                @JsonProperty("lt1") String lt1,
                @JsonProperty("qv") int qv,
                @JsonProperty("vs") List<VeiculoStatus> vs) {
            this.c = c;
            this.cl = cl;
            this.sl = sl;
            this.lt0 = lt0;
            this.lt1 = lt1;
            this.qv = qv;
            this.vs = vs;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class VeiculoStatus {
        private int p;
        private boolean a;
        private String ta;
        private double py;
        private double px;
    }
}
