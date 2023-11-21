package org.example;

public enum PreciosAsientos {;
    public enum CantidadAsientos{
        PreciosAsientosCama(20000),
        PrecioAsientosSemiCama(15000);
        private final int valor;
        CantidadAsientos(int valor){
            this.valor=valor;
        }

        public int getValor() {
            return valor;
        }
    }
}
