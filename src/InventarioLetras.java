public class InventarioLetras {

        private int[] contadores;
        private int totalCount;
        private int nonZeroCount;
        private static final int ABECEDARIO_TAMANIO = 26;

        public InventarioLetras(String data) {
            this.contadores = new int[ABECEDARIO_TAMANIO];
            this. totalCount = 0;
            this.nonZeroCount = 0;

            if (data != null){
                String textoMinusculas = data.toLowerCase();

                for (int i = 0; i < textoMinusculas.length(); i++){
                    char caracter = textoMinusculas.charAt(i);

                    if(caracter >= 'a' && caracter <= 'z') {
                        int indice = caracter - 'a';
                        this.contadores[indice]++;
                        this.totalCount++;
                    }
                }
                for (int i = 0; i < ABECEDARIO_TAMANIO; i++){
                    if(this.contadores[i] > 0) {
                        this.nonZeroCount++;
                    }
                }
            }

        }

        public int get(char letra) {
            return 0;
        }

        public int size() {
            return this.totalCount;
        }

        public boolean isEmpty() {
            return this.nonZeroCount == 0;
        }

        public String toString() {
            return null;
        }

        public char encriptarCesar(char letra) {
            return ' ';
        }

        public char desencriptarCesar(char letra) {
            return ' ';
        }

        public String encriptarPalabra(String palabra, int desplazamiento) {
            return null;
        }

        public String desencriptarPalabra(String palabra, int desplazamiento) {
            return null;
        }

        public void set(char letra, int valor) {
        }

        public InventarioLetras add(InventarioLetras otro) {
            return null;
        }

        public InventarioLetras amplifies(int n) {
            return null;
        }

        public InventarioLetras subtract(InventarioLetras otro) {
            return null;
        }
    }
