package com.rogo.UtilityClasses.responseMessages;

public enum SuccessMessages {

    ADD{
        @Override
        public String toString() {
            return "ADDED SUCCESSFULLY";
        }
    },
    EDIT{
        @Override
        public String toString() {
            return "EDITED SUCCESSFULLY";
        }
    },
    DELETE{
        @Override
        public String toString() {
            return "DELETED SUCCESSFULLY";
        }
    },
    FOUND{
        @Override
        public String toString() {
            return "FOUND";
        }
    }
}
