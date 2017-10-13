package HW4;

public enum Engines implements Descriable {
    DIESEL {
        @Override
        public String getDescription() {
            return "Diesel engine";
        }
    },
    PETROL {
        @Override
        public String getDescription() {
            return "Petrol engine";
        }
    },
    GAS {
        @Override
        public String getDescription() {
            return "Gas engine";
        }
    },
    ELECTRIC {
        @Override
        public String getDescription() {
            return "Electric engine";
        }
    }
}
