package com.rogo.UtilityClasses.responseMessages;

public enum ErrorMessages {
    Q_NOT_FOUND{
        @Override
        public String toString() {
            return "QUESTION NOT FOUND";
        }
    },

    Q_TYPE_NOT_FOUND{
        @Override
        public String toString() {
            return "QUESTION TYPE NOT FOUND";
        }
    }
}
