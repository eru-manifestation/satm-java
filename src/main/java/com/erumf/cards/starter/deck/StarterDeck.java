package com.erumf.cards.starter.deck;

import java.util.ArrayList;
import java.util.List;

import com.erumf.Basic;
import com.erumf.Player;
import com.erumf.cards.starter.deck.StarterAllies.Gollum;
import com.erumf.cards.starter.deck.StarterAllies.Quickbeam;
import com.erumf.cards.starter.deck.StarterCharacters.AragornII;
import com.erumf.cards.starter.deck.StarterCharacters.Beregond;
import com.erumf.cards.starter.deck.StarterCharacters.BoromirII;
import com.erumf.cards.starter.deck.StarterCharacters.Eomer;
import com.erumf.cards.starter.deck.StarterCharacters.Erkenbrand;
import com.erumf.cards.starter.deck.StarterCharacters.Faramir;
import com.erumf.cards.starter.deck.StarterCharacters.Gandalf;
import com.erumf.cards.starter.deck.StarterCharacters.Kili;
import com.erumf.cards.starter.deck.StarterCharacters.Merry;
import com.erumf.cards.starter.deck.StarterEventResources.Bridge;
import com.erumf.cards.starter.deck.StarterEventResources.Concealment;
import com.erumf.cards.starter.deck.StarterEventResources.Dodge;
import com.erumf.cards.starter.deck.StarterEventResources.Escape;
import com.erumf.cards.starter.deck.StarterEventResources.Ford;
import com.erumf.cards.starter.deck.StarterEventResources.HalflingStealth;
import com.erumf.cards.starter.deck.StarterEventResources.HalflingStrength;
import com.erumf.cards.starter.deck.StarterEventResources.LuckyStrike;
import com.erumf.cards.starter.deck.StarterEventResources.Muster;
import com.erumf.cards.starter.deck.StarterEventResources.TemperingFriendship;
import com.erumf.cards.starter.deck.StarterFactions.Dunlendings;
import com.erumf.cards.starter.deck.StarterFactions.EntsOfFangorn;
import com.erumf.cards.starter.deck.StarterFactions.RangersOfTheNorth;
import com.erumf.cards.starter.deck.StarterFactions.RidersOfRohan;
import com.erumf.cards.starter.deck.StarterFactions.TowerGuardOfMinasTirith;
import com.erumf.cards.starter.deck.StarterFactions.WoodElves;
import com.erumf.cards.starter.deck.StarterHazards.ArouseMinions;
import com.erumf.cards.starter.deck.StarterHazards.BertBurat;
import com.erumf.cards.starter.deck.StarterHazards.Brigands;
import com.erumf.cards.starter.deck.StarterHazards.MinionsStir;
import com.erumf.cards.starter.deck.StarterHazards.OrcGuard;
import com.erumf.cards.starter.deck.StarterHazards.OrcRaiders;
import com.erumf.cards.starter.deck.StarterHazards.OrcWarriors;
import com.erumf.cards.starter.deck.StarterHazards.OrcWatch;
import com.erumf.cards.starter.deck.StarterHazards.River;
import com.erumf.cards.starter.deck.StarterHazards.WilliamWuluag;
import com.erumf.cards.starter.deck.StarterItems.ElvenCloak;
import com.erumf.cards.starter.deck.StarterItems.Glamdring;
import com.erumf.cards.starter.deck.StarterItems.GreatShieldOfRohan;
import com.erumf.cards.starter.deck.StarterItems.ScrollOfIsildur;
import com.erumf.cards.starter.deck.StarterItems.ShieldOfIronBoundAsh;

public class StarterDeck {

    public static List<Basic> defaultDeck1(Player player1) {
        List<Basic> deck = new ArrayList<>();

        // Adding characters
        deck.add(new AragornII(player1)); // G01
        deck.add(new BoromirII(player1)); // G02
        deck.add(new ShieldOfIronBoundAsh(player1)); // G03
        deck.add(new Kili(player1)); // G04
        deck.add(new Merry(player1)); // G05
        deck.add(new ElvenCloak(player1)); // G06
        deck.add(new Dodge(player1)); // G07
        deck.add(new RangersOfTheNorth(player1)); // G08
        deck.add(new LuckyStrike(player1)); // G09
        deck.add(new TemperingFriendship(player1)); // G10
        deck.add(new Concealment(player1)); // G11
        deck.add(new BertBurat(player1)); // G12
        deck.add(new OrcRaiders(player1)); // G13
        deck.add(new OrcGuard(player1)); // G14
        deck.add(new OrcWarriors(player1)); // G15
        deck.add(new ArouseMinions(player1)); // G16
        deck.add(new Beregond(player1)); // G17
        deck.add(new Brigands(player1)); // G18
        deck.add(new River(player1)); // G19
        deck.add(new HalflingStrength(player1)); // G20
        deck.add(new ScrollOfIsildur(player1)); // G21
        deck.add(new Faramir(player1)); // G22
        deck.add(new Dodge(player1)); // G23
        deck.add(new LuckyStrike(player1)); // G24
        deck.add(new Eomer(player1)); // G25
        deck.add(new Gandalf(player1)); // G26
        deck.add(new GreatShieldOfRohan(player1)); // G27
        deck.add(new WilliamWuluag(player1)); // G28
        deck.add(new Escape(player1)); // G29
        deck.add(new OrcGuard(player1)); // G30
        deck.add(new Quickbeam(player1)); // G31
        deck.add(new Brigands(player1)); // G32
        deck.add(new Concealment(player1)); // G33
        deck.add(new OrcWarriors(player1)); // G34
        deck.add(new Escape(player1)); // G35
        deck.add(new MinionsStir(player1)); // G36
        deck.add(new ArouseMinions(player1)); // G37
        deck.add(new Gandalf(player1)); // G38
        deck.add(new Dodge(player1)); // G39
        deck.add(new LuckyStrike(player1)); //G40
        deck.add(new Glamdring(player1)); // G41
        deck.add(new OrcRaiders(player1)); // G42
        deck.add(new RidersOfRohan(player1)); // G43
        deck.add(new Erkenbrand(player1)); // G44
        deck.add(new OrcGuard(player1)); // G45
        deck.add(new MinionsStir(player1)); // G46
        deck.add(new OrcWatch(player1)); // G47
        deck.add(new River(player1)); // G48
        deck.add(new Brigands(player1)); // G49
        deck.add(new Ford(player1)); // G50
        deck.add(new HalflingStrength(player1)); // G51
        deck.add(new OrcRaiders(player1)); // G52
        deck.add(new TowerGuardOfMinasTirith(player1)); // G53
        deck.add(new OrcWarriors(player1)); // G54
        deck.add(new Bridge(player1)); // G55
        deck.add(new HalflingStealth(player1)); // G56
        deck.add(new OrcWatch(player1)); // G57
        deck.add(new ArouseMinions(player1)); // G58
        deck.add(new Muster(player1)); // G59
        deck.add(new OrcWatch(player1)); // G60

        return deck;
    }

    public static List<Basic> defaultDeck2(Player player2) {
        List<Basic> deck = new ArrayList<>();
        
        // Adding characters

        // Adding objects

        // Adding resources

        // Adding hazards

        // Adding allies
        deck.add(new Gollum(player2)); // S33

        // Adding factions
        deck.add(new Dunlendings(player2)); // S15
        deck.add(new WoodElves(player2)); // S27
        deck.add(new EntsOfFangorn(player2)); // S53

        return deck;
    }

    public StarterDeck() {
        // Constructor
    }
}
