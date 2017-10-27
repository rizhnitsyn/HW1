package Robots.Details;

public enum DetailName implements Descriable {
    HEAD {
        @Override
        public String getDescription() {
            return "Head";
        }
    },
    BODY {
        @Override
        public String getDescription() {
            return "Body";
        }
    },
    LEFT_HAND {
        @Override
        public String getDescription() {
            return "Left_hand";
        }
    },
    RIGHT_HAND {
        @Override
        public String getDescription() {
            return "Right_hand";
        }
    },
    LEFT_LEG {
        @Override
        public String getDescription() {
            return "Left_leg";
        }
    },
    RIGHT_LEG {
        @Override
        public String getDescription() {
            return "Right_leg";
        }
    },
    CPU {
        @Override
        public String getDescription() {
            return "CPU";
        }
    },
    RAM {
        @Override
        public String getDescription() {
            return "RAM";
        }
    },
    HDD {
        @Override
        public String getDescription() {
            return "HDD";
        }
    }
}
