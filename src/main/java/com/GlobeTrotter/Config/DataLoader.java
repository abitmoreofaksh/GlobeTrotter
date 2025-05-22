package com.GlobeTrotter.Config;

import com.GlobeTrotter.Entity.Clue;
import com.GlobeTrotter.Entity.Destination;
import com.GlobeTrotter.Entity.Fact;
import com.GlobeTrotter.Repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DataLoader(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public void run(String... args) {
        // Only load data if the database is empty
        if (destinationRepository.count() == 0) {
            loadSampleDestinations();
        }
    }

    private void loadSampleDestinations() {


        Destination paris = new Destination();
        paris.setName("Paris");
        paris.setCountry("France");
        paris.setImageUrl("https://plus.unsplash.com/premium_photo-1661919210043-fd847a58522d?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue parisClue1 = new Clue();
        parisClue1.setText("This city is known as the 'City of Light'.");
        parisClue1.setDifficulty(1);
        parisClue1.setDestination(paris);

        Clue parisClue2 = new Clue();
        parisClue2.setText("A famous iron tower dominates its skyline.");
        parisClue2.setDifficulty(1);
        parisClue2.setDestination(paris);

        Clue parisClue3 = new Clue();
        parisClue3.setText("This city has a famous museum that houses the Mona Lisa.");
        parisClue3.setDifficulty(2);
        parisClue3.setDestination(paris);

        Fact parisFact1 = new Fact();
        parisFact1.setText("The Eiffel Tower was built for the 1889 World's Fair and was initially criticized by many Parisians.");
        parisFact1.setIsTrivia(true);
        parisFact1.setDestination(paris);

        Fact parisFact2 = new Fact();
        parisFact2.setText("Paris has over 450 parks and gardens throughout the city.");
        parisFact2.setIsTrivia(false);
        parisFact2.setDestination(paris);

        paris.setClues(List.of(parisClue1, parisClue2, parisClue3));
        paris.setFacts(List.of(parisFact1, parisFact2));

        destinationRepository.save(paris);




        Destination nyc = new Destination();
        nyc.setName("New York City");
        nyc.setCountry("United States");
        nyc.setImageUrl("https://images.unsplash.com/photo-1543716091-a840c05249ec?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue nycClue1 = new Clue();
        nycClue1.setText("This city is known as the 'Big Apple'.");
        nycClue1.setDifficulty(1);
        nycClue1.setDestination(nyc);

        Clue nycClue2 = new Clue();
        nycClue2.setText("A famous green statue stands in its harbor.");
        nycClue2.setDifficulty(1);
        nycClue2.setDestination(nyc);

        Clue nycClue3 = new Clue();
        nycClue3.setText("This city has a famous square known for its New Year's Eve ball drop.");
        nycClue3.setDifficulty(2);
        nycClue3.setDestination(nyc);

        Fact nycFact1 = new Fact();
        nycFact1.setText("The Statue of Liberty was a gift from France to the United States in 1886.");
        nycFact1.setIsTrivia(true);
        nycFact1.setDestination(nyc);

        Fact nycFact2 = new Fact();
        nycFact2.setText("New York City has over 8.4 million residents and is the most populous city in the United States.");
        nycFact2.setIsTrivia(false);
        nycFact2.setDestination(nyc);

        nyc.setClues(List.of(nycClue1, nycClue2, nycClue3));
        nyc.setFacts(List.of(nycFact1, nycFact2));

        destinationRepository.save(nyc);




        Destination tokyo = new Destination();
        tokyo.setName("Tokyo");
        tokyo.setCountry("Japan");
        tokyo.setImageUrl("https://plus.unsplash.com/premium_photo-1661914240950-b0124f20a5c1?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue tokyoClue1 = new Clue();
        tokyoClue1.setText("This city is the world's most populous metropolitan area.");
        tokyoClue1.setDifficulty(2);
        tokyoClue1.setDestination(tokyo);

        Clue tokyoClue2 = new Clue();
        tokyoClue2.setText("A famous mountain can be seen from this city on clear days.");
        tokyoClue2.setDifficulty(2);
        tokyoClue2.setDestination(tokyo);

        Clue tokyoClue3 = new Clue();
        tokyoClue3.setText("This city hosted the Summer Olympics twice, most recently in 2021.");
        tokyoClue3.setDifficulty(1);
        tokyoClue3.setDestination(tokyo);

        Fact tokyoFact1 = new Fact();
        tokyoFact1.setText("Tokyo has the world's busiest pedestrian crossing at Shibuya.");
        tokyoFact1.setIsTrivia(true);
        tokyoFact1.setDestination(tokyo);

        Fact tokyoFact2 = new Fact();
        tokyoFact2.setText("There are over 36 million people in the Greater Tokyo Area.");
        tokyoFact2.setIsTrivia(false);
        tokyoFact2.setDestination(tokyo);

        tokyo.setClues(List.of(tokyoClue1, tokyoClue2, tokyoClue3));
        tokyo.setFacts(List.of(tokyoFact1, tokyoFact2));

        destinationRepository.save(tokyo);



        Destination rome = new Destination();
        rome.setName("Rome");
        rome.setCountry("Italy");
        rome.setImageUrl("https://plus.unsplash.com/premium_photo-1676392237398-0515d29c4736?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue romeClue1 = new Clue();
        romeClue1.setText("This city is home to the Colosseum.");
        romeClue1.setDifficulty(1);
        romeClue1.setDestination(rome);

        Clue romeClue2 = new Clue();
        romeClue2.setText("It was the heart of an ancient empire.");
        romeClue2.setDifficulty(2);
        romeClue2.setDestination(rome);

        Clue romeClue3 = new Clue();
        romeClue3.setText("A small independent country, the Vatican, is located within this city.");
        romeClue3.setDifficulty(2);
        romeClue3.setDestination(rome);

        Fact romeFact1 = new Fact();
        romeFact1.setText("Rome has a fountain that collects over €1 million in coins annually.");
        romeFact1.setIsTrivia(true);
        romeFact1.setDestination(rome);

        Fact romeFact2 = new Fact();
        romeFact2.setText("The Colosseum could hold up to 50,000 spectators.");
        romeFact2.setIsTrivia(false);
        romeFact2.setDestination(rome);

        rome.setClues(List.of(romeClue1, romeClue2, romeClue3));
        rome.setFacts(List.of(romeFact1, romeFact2));

        destinationRepository.save(rome);


        Destination cairo = new Destination();
        cairo.setName("Cairo");
        cairo.setCountry("Egypt");
        cairo.setImageUrl("https://images.unsplash.com/photo-1582414119841-96c80f5225ec?q=80&w=2071&auto=format&fit=crop");

        Clue cairoClue1 = new Clue();
        cairoClue1.setText("This city is home to the only remaining Wonder of the Ancient World.");
        cairoClue1.setDifficulty(1);
        cairoClue1.setDestination(cairo);

        Clue cairoClue2 = new Clue();
        cairoClue2.setText("A river flows through this city, often associated with ancient pharaohs.");
        cairoClue2.setDifficulty(2);
        cairoClue2.setDestination(cairo);

        Clue cairoClue3 = new Clue();
        cairoClue3.setText("This city has a museum that holds King Tutankhamun’s treasures.");
        cairoClue3.setDifficulty(2);
        cairoClue3.setDestination(cairo);

        Fact cairoFact1 = new Fact();
        cairoFact1.setText("The Great Pyramid of Giza was the tallest structure in the world for over 3,800 years.");
        cairoFact1.setIsTrivia(true);
        cairoFact1.setDestination(cairo);

        Fact cairoFact2 = new Fact();
        cairoFact2.setText("Cairo has the oldest and largest film industry in the Arab world.");
        cairoFact2.setIsTrivia(false);
        cairoFact2.setDestination(cairo);

        cairo.setClues(List.of(cairoClue1, cairoClue2, cairoClue3));
        cairo.setFacts(List.of(cairoFact1, cairoFact2));

        destinationRepository.save(cairo);

        // London
        Destination london = new Destination();
        london.setName("London");
        london.setCountry("United Kingdom");
        london.setImageUrl("https://images.unsplash.com/photo-1529655683826-aba9b3e77383?q=80&w=2565&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue londonClue1 = new Clue();
        londonClue1.setText("This city is home to Big Ben and the Houses of Parliament.");
        londonClue1.setDifficulty(1);
        londonClue1.setDestination(london);

        Clue londonClue2 = new Clue();
        londonClue2.setText("Buckingham Palace is located in this city.");
        londonClue2.setDifficulty(1);
        londonClue2.setDestination(london);

        Clue londonClue3 = new Clue();
        londonClue3.setText("This city's underground transit system is known as 'The Tube'.");
        londonClue3.setDifficulty(2);
        londonClue3.setDestination(london);

        Fact londonFact1 = new Fact();
        londonFact1.setText("The London Eye is Europe's tallest cantilevered observation wheel at 135 meters high.");
        londonFact1.setIsTrivia(true);
        londonFact1.setDestination(london);

        Fact londonFact2 = new Fact();
        londonFact2.setText("London has been a major settlement for over 2,000 years and was founded by the Romans, who named it Londinium.");
        londonFact2.setIsTrivia(false);
        londonFact2.setDestination(london);

        london.setClues(List.of(londonClue1, londonClue2, londonClue3));
        london.setFacts(List.of(londonFact1, londonFact2));

        destinationRepository.save(london);

// Cape Town
        Destination capeTown = new Destination();
        capeTown.setName("Cape Town");
        capeTown.setCountry("South Africa");
        capeTown.setImageUrl("https://images.unsplash.com/photo-1580060839134-75a5edca2e99?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue capeTownClue1 = new Clue();
        capeTownClue1.setText("This city is overlooked by Table Mountain.");
        capeTownClue1.setDifficulty(1);
        capeTownClue1.setDestination(capeTown);

        Clue capeTownClue2 = new Clue();
        capeTownClue2.setText("Robben Island, where Nelson Mandela was imprisoned, is located near this city.");
        capeTownClue2.setDifficulty(2);
        capeTownClue2.setDestination(capeTown);

        Clue capeTownClue3 = new Clue();
        capeTownClue3.setText("This city is at the southwestern tip of Africa where two oceans meet.");
        capeTownClue3.setDifficulty(2);
        capeTownClue3.setDestination(capeTown);

        Fact capeTownFact1 = new Fact();
        capeTownFact1.setText("Cape Town is the legislative capital of South Africa and houses the country's Parliament.");
        capeTownFact1.setIsTrivia(false);
        capeTownFact1.setDestination(capeTown);

        Fact capeTownFact2 = new Fact();
        capeTownFact2.setText("The Cape of Good Hope, near Cape Town, was originally named the 'Cape of Storms' by Portuguese explorer Bartolomeu Dias.");
        capeTownFact2.setIsTrivia(true);
        capeTownFact2.setDestination(capeTown);

        capeTown.setClues(List.of(capeTownClue1, capeTownClue2, capeTownClue3));
        capeTown.setFacts(List.of(capeTownFact1, capeTownFact2));

        destinationRepository.save(capeTown);

// Delhi
        Destination delhi = new Destination();
        delhi.setName("Delhi");
        delhi.setCountry("India");
        delhi.setImageUrl("https://images.unsplash.com/photo-1587474260584-136574528ed5?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue delhiClue1 = new Clue();
        delhiClue1.setText("The Red Fort is a historic landmark in this city.");
        delhiClue1.setDifficulty(1);
        delhiClue1.setDestination(delhi);

        Clue delhiClue2 = new Clue();
        delhiClue2.setText("India Gate, a war memorial, is located in this city.");
        delhiClue2.setDifficulty(2);
        delhiClue2.setDestination(delhi);

        Clue delhiClue3 = new Clue();
        delhiClue3.setText("This city is the capital of India and home to the Lotus Temple.");
        delhiClue3.setDifficulty(1);
        delhiClue3.setDestination(delhi);

        Fact delhiFact1 = new Fact();
        delhiFact1.setText("Delhi has been continuously inhabited since the 6th century BCE and has been the capital of various empires.");
        delhiFact1.setIsTrivia(false);
        delhiFact1.setDestination(delhi);

        Fact delhiFact2 = new Fact();
        delhiFact2.setText("The Qutub Minar in Delhi is the tallest brick minaret in the world at 73 meters high.");
        delhiFact2.setIsTrivia(true);
        delhiFact2.setDestination(delhi);

        delhi.setClues(List.of(delhiClue1, delhiClue2, delhiClue3));
        delhi.setFacts(List.of(delhiFact1, delhiFact2));

        destinationRepository.save(delhi);

// Mumbai
        Destination mumbai = new Destination();
        mumbai.setName("Mumbai");
        mumbai.setCountry("India");
        mumbai.setImageUrl("https://images.unsplash.com/photo-1529253355930-ddbe423a2ac7?q=80&w=1742&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue mumbaiClue1 = new Clue();
        mumbaiClue1.setText("This city is home to Bollywood, the world's largest film industry by number of films produced.");
        mumbaiClue1.setDifficulty(1);
        mumbaiClue1.setDestination(mumbai);

        Clue mumbaiClue2 = new Clue();
        mumbaiClue2.setText("The Gateway of India, a historic arch monument, is located in this city.");
        mumbaiClue2.setDifficulty(2);
        mumbaiClue2.setDestination(mumbai);

        Clue mumbaiClue3 = new Clue();
        mumbaiClue3.setText("This city was formerly known as Bombay.");
        mumbaiClue3.setDifficulty(1);
        mumbaiClue3.setDestination(mumbai);

        Fact mumbaiFact1 = new Fact();
        mumbaiFact1.setText("Mumbai is the financial, commercial, and entertainment capital of India.");
        mumbaiFact1.setIsTrivia(false);
        mumbaiFact1.setDestination(mumbai);

        Fact mumbaiFact2 = new Fact();
        mumbaiFact2.setText("Mumbai's local train system carries over 7.5 million passengers daily, making it one of the busiest commuter rail systems in the world.");
        mumbaiFact2.setIsTrivia(true);
        mumbaiFact2.setDestination(mumbai);

        mumbai.setClues(List.of(mumbaiClue1, mumbaiClue2, mumbaiClue3));
        mumbai.setFacts(List.of(mumbaiFact1, mumbaiFact2));

        destinationRepository.save(mumbai);

// Rishikesh
        Destination rishikesh = new Destination();
        rishikesh.setName("Rishikesh");
        rishikesh.setCountry("India");
        rishikesh.setImageUrl("https://plus.unsplash.com/premium_photo-1697730398251-40cd8dc57e0b?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        Clue rishikeshClue1 = new Clue();
        rishikeshClue1.setText("This city is known as the 'Yoga Capital of the World'.");
        rishikeshClue1.setDifficulty(2);
        rishikeshClue1.setDestination(rishikesh);

        Clue rishikeshClue2 = new Clue();
        rishikeshClue2.setText("The Beatles visited an ashram in this city in 1968 to study Transcendental Meditation.");
        rishikeshClue2.setDifficulty(3);
        rishikeshClue2.setDestination(rishikesh);

        Clue rishikeshClue3 = new Clue();
        rishikeshClue3.setText("This city sits on the banks of the holy Ganges River at the foothills of the Himalayas.");
        rishikeshClue3.setDifficulty(2);
        rishikeshClue3.setDestination(rishikesh);

        Fact rishikeshFact1 = new Fact();
        rishikeshFact1.setText("Rishikesh is a pilgrimage town and is regarded as one of the holiest places for Hindus.");
        rishikeshFact1.setIsTrivia(false);
        rishikeshFact1.setDestination(rishikesh);

        Fact rishikeshFact2 = new Fact();
        rishikeshFact2.setText("The Lakshman Jhula is a 450-foot long suspension bridge across the Ganges that was built in 1929 and is a prominent landmark in Rishikesh.");
        rishikeshFact2.setIsTrivia(true);
        rishikeshFact2.setDestination(rishikesh);

        rishikesh.setClues(List.of(rishikeshClue1, rishikeshClue2, rishikeshClue3));
        rishikesh.setFacts(List.of(rishikeshFact1, rishikeshFact2));

        destinationRepository.save(rishikesh);


        // Add more destinations as needed to reach 100+ total

        System.out.println("Sample destinations loaded successfully!");
    }
}
