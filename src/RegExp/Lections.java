package RegExp;

public enum Lections implements Descriable{
    LECTION {
        @Override
        public String getDescription() {
            return "Лекция";
        }
    },
    INTRODUCTION {
        @Override
        public String getDescription() {
            return "Введение";
        }
    },
    SCALAR {
        @Override
        public String getDescription() {
            return "Скаляры";
        }
    },
    ARRAY {
        @Override
        public String getDescription() {
            return "Массивы";
        }
    },
    DEEP_ARRAY {
        @Override
        public String getDescription() {
            return "Углубленное изучение массивов";
        }
    },
    CYCLE {
        @Override
        public String getDescription() {
            return "Циклы";
        }
    },
    LOGICAL_OPERATOR {
        @Override
        public String getDescription() {
            return "Логические операторы";
        }
    },
    CONCURRENCY {
        @Override
        public String getDescription() {
            return "Многопоточность";
        }
    },
    SYNCHRONIZATION {
        @Override
        public String getDescription() {
            return "Синхронизация";
        }
    },
    SET {
        @Override
        public String getDescription() {
            return "Множества";
        }
    },
    ENCLOSED_ARRAY {
        @Override
        public String getDescription() {
            return "Вложенные массивы";
        }
    },
    DYNAMIC_ARRAY {
        @Override
        public String getDescription() {
            return "Динамический массивы";
        }
    },
    LISTS {
        @Override
        public String getDescription() {
            return "Списки";
        }
    }
}
