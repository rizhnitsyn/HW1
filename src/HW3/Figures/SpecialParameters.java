package HW3.Figures;

public enum SpecialParameters implements Descriable {
    RECTANGLE {
        @Override
        public String getDescription() {
            return "Diagonal";
        }
    },
    TRIANGLE {
        @Override
        public String getDescription() {
            return "Triangle Height";
        }
    },
    CIRCLE {
        @Override
        public String getDescription() {
            return "Diameter";
        }
    },
    ELLIPS {
        @Override
        public String getDescription() {
            return null;
        }
    },
}
