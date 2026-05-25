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
            char letraMinuscula = Character.toLowerCase(letra);

            if(letraMinuscula < 'a' || letraMinuscula > 'z'){
                throw new IllegalArgumentException("El caracter'" + letra + "'no es una letra valida del alfabeto ingles");

            }
            int indice = letraMinuscula - 'a';
            return this.contadores[indice];
        }

        public int size() {
            return this.totalCount;
        }

        public boolean isEmpty() {
            return this.nonZeroCount == 0;
        }

        public String toString() {
            StringBuilder resultado = new StringBuilder("[");

            for(int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                int cantidad = this.contadores[i];

                for(int j = 0; j < cantidad; j++) {
                    char letra = (char) ('a' + i);
                    resultado.append(letra);
                }
            }
            resultado.append("]");
            return resultado.toString();
        }

        public char encriptarCesar(char letra) {
            char letraMinuscula = Character.toLowerCase(letra);
            if (letraMinuscula < 'a' || letraMinuscula > 'z') {
                return letra;
            }
            int posicionOriginal = letraMinuscula - 'a';
            int nuevaPosicion = (posicionOriginal + 3) % ABECEDARIO_TAMANIO;

            return (char) ('a' + nuevaPosicion);
        }


        public char desencriptarCesar(char letra) {
            char letraMinuscula = Character.toLowerCase(letra);

            if (letraMinuscula < 'a' || letraMinuscula > 'z') {
                return letra;
            }

            int posicionOriginal = letraMinuscula - 'a';
            int nuevaPosicion = (posicionOriginal - 3 + ABECEDARIO_TAMANIO) % ABECEDARIO_TAMANIO;

            return (char) ('a' + nuevaPosicion);
        }


        public String encriptarPalabra(String palabra, int desplazamiento) {
            if (palabra == null) {
                return null;
            }

            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < palabra.length(); i++) {
                char letraOriginal = palabra.charAt(i);
                char letraEncriptada = encriptarCesar(letraOriginal);
                resultado.append(letraEncriptada);
            }

            return resultado.toString();
        }

        public String desencriptarPalabra(String palabra, int desplazamiento) {
            if (palabra == null) {
                return null;
            }

            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < palabra.length(); i++) {
                char letraOriginal = palabra.charAt(i);
                char letraDesencriptada = desencriptarCesar(letraOriginal);
                resultado.append(letraDesencriptada);
            }

            return resultado.toString();
        }


        public void set(char letra, int valor) {
            char letraMinuscula = Character.toLowerCase(letra);

            if (letraMinuscula < 'a' || letraMinuscula > 'z') {
                throw new IllegalArgumentException("Carácter no alfabético.");
            }

            if (valor < 0) {
                throw new IllegalArgumentException("El valor no puede ser negativo.");
            }

            int indice = letraMinuscula - 'a';
            int valorAnterior = this.contadores[indice];

            this.contadores[indice] = valor;

            this.totalCount = this.totalCount - valorAnterior + valor;

            if (valorAnterior == 0 && valor > 0) {
                this.nonZeroCount++;
            } else if (valorAnterior > 0 && valor == 0) {
                this.nonZeroCount--;
            }
        }

        public InventarioLetras add(InventarioLetras otro) {
            if (otro == null) {
                return null;
            }

            InventarioLetras nuevoInventario = new InventarioLetras("");

            for (int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                int suma = this.contadores[i] + otro.contadores[i];
                nuevoInventario.contadores[i] = suma;
            }

            nuevoInventario.totalCount = this.totalCount + otro.totalCount;

            for (int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                if (nuevoInventario.contadores[i] > 0) {
                    nuevoInventario.nonZeroCount++;
                }
            }

            return nuevoInventario;
        }

        public InventarioLetras amplifies(int n) {
            InventarioLetras nuevoInventario = new InventarioLetras("");

            if (n <= 0) {
                return nuevoInventario;
            }

            for (int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                nuevoInventario.contadores[i] = this.contadores[i] * n;
            }

            nuevoInventario.totalCount = this.totalCount * n;

            for (int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                if (nuevoInventario.contadores[i] > 0) {
                    nuevoInventario.nonZeroCount++;
                }
            }

            return nuevoInventario;
        }

        public InventarioLetras subtract(InventarioLetras otro) {
            if (otro == null) {
                return null;
            }

            InventarioLetras nuevoInventario = new InventarioLetras("");

            for (int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                int resta = this.contadores[i] - otro.contadores[i];

                if (resta < 0) {
                    return null;
                }

                nuevoInventario.contadores[i] = resta;
            }

            nuevoInventario.totalCount = this.totalCount - otro.totalCount;

            for (int i = 0; i < ABECEDARIO_TAMANIO; i++) {
                if (nuevoInventario.contadores[i] > 0) {
                    nuevoInventario.nonZeroCount++;
                }
            }

            return nuevoInventario;
        }
    }
