package com.rogo.Utils.responseKeys;

public enum Questions {
    QUESTION{
        @Override
        public String toString() {
            return "question";
        }
    },
    QUESTIONS{
        @Override
        public String toString() {
            return "questions";
        }
    },
    MCQ{
        @Override
        public String toString() {
        return "mcqQuestions";
        }
    },
    CODING{
        @Override
        public String toString() {
            return "codingQuestions";
        }
    }
}
