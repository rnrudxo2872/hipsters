package com.dosters.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CommonOutput {
    public Boolean ok;
    public String error;

    public static CommonOutput getStatus(Boolean ok, String error) {
        return new CommonOutput(ok, error);
    }

    public void setStatus(Boolean ok, String error) {
        this.ok = ok;
        this.error = error;
    }

    @NoArgsConstructor
    public static class builder {
        private Boolean ok;
        private String error;

        public builder ok(Boolean ok) {
            this.ok = ok;
            return this;
        }

        public builder error(String error) {
            this.error = error;
            return this;
        }

        public CommonOutput build() {
            return new CommonOutput(this);
        }
    }

    private CommonOutput(builder builder) {
        ok = builder.ok;
        error = builder.error;
    }
}
