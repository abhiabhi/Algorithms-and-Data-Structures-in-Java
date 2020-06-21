package com.design;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * This design uses Strategy Pattern
 *
 * Strategy pattern and the open closed principle
 * According to the strategy pattern, the behaviour of a class should be encapsulated
 * using interfaces and should not be inherited.
 * This is compatible with the open closed principle,
 */

public class LowLevelDesign {

    MessageProcessor processor;

    class MessageConsumer implements MessageListener{

        @JMSListener
        public void onMessage(Message message){
            if (message instanceof  TextMessage){
                processor = new MessageProcessor();
                MessageParser mp = new swiftParser();
                processor.setParser(mp);
                processor.process(message);
            }
            if (message instanceof BytesMessage){

            }


        }

    }

    class MessageProcessor {

        MessageParser parser;

        public void setParser(MessageParser p){
            this.parser = p;
        }

        public void process(Message message){
            parser.parse(message);
        }

    }

    interface MessageParser{
        void parse(Message message);
    }

    class SwiftParser implements MessageParser{

        @Override
        public void parse(Message message) {

        }
    }
     class JsonParser implements  MessageParser{

         @Override
         public void parse(Message message) {

         }
     }
    class XMLParser implements  MessageParser{

        @Override
        public void parse(Message message) {

        }
    }

}
