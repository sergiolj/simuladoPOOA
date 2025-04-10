package br.ucsal.biblioteca.threads.model;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PessoaChat implements Runnable {
    private final int numberOfMessages;
    private final int messagesPerSecond;
    private final String name;
    private type chatType;
    private final String [] questions = {
            "Olá, como vai voce?",
            "Tudo bem?",
            "Você está com tempo para conversar?",
            "O que está fazendo?",
            "Posso te fazer uma pergunta?",
            "Aceita um café?"
    };
    private final String [] anwsers = {
            "Estou bem, voltei a estudar",
            "Claro, eu iria adorar",
            "Sim, vai ser demais!",
            "Nada demais, só descansando.",
            "Sim, me arrumando para sair daqui a pouco",
            "Claro que sim.",
    };
    public enum type{
        ANSWER,
        ASK
    }

    public PessoaChat(String name, int numberOfMessages, int messagesPerSecond, type chatType) {
        this.name = name;
        this.numberOfMessages = numberOfMessages;
        this.messagesPerSecond = messagesPerSecond;
        this.chatType = chatType;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        String[] sentences = new String[numberOfMessages];
        if (chatType == type.ANSWER) {
            sentences = this.questions;
        }else if (chatType == type.ASK) {
            sentences = this.anwsers;
        }
        int index = 0;
        Random rand = new Random();
        for(int i = 0; i < sentences.length; i++) {
            index = rand.nextInt(sentences.length);
            System.out.println(name + " : " + sentences[index]);
            try {
                Thread.sleep(Duration.ofSeconds(messagesPerSecond).toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


