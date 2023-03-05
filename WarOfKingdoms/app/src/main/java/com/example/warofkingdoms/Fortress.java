package com.example.warofkingdoms;

public class Fortress {
        private int life;
        private int armor;

        public Fortress(int life, int armor) {
            this.life = life;
            this.armor = armor;
        }

        public int getLife() {
            return life;
        }

        public void setLife(int life) {
            this.life = life;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }


