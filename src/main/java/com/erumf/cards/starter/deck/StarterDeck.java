package com.erumf.cards.starter.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.erumf.Basic;
import com.erumf.Player;
import com.erumf.cards.locations.Locations;
import com.erumf.elements.Character;
import com.erumf.elements.Hazard;
import com.erumf.elements.Item;
import com.erumf.elements.Resource;

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
        deck.add(new LuckyStrike(player1)); // G09
        deck.add(new TemperingFriendship(player1)); // G10
        deck.add(new Concealment(player1)); // G11
        deck.add(new BertBurat(player1)); // G12
        deck.add(new OrcRaiders(player1)); // G13
        deck.add(new OrcGuard(player1)); // G14
        deck.add(new OrcWarriors(player1)); // G15
        deck.add(new Beregond(player1)); // G17
        deck.add(new HalflingStrength(player1)); // G20
        deck.add(new ScrollOfIsildur(player1)); // G21
        deck.add(new Faramir(player1)); // G22
        deck.add(new Dodge(player1)); // G23
        deck.add(new LuckyStrike(player1)); // G24
        deck.add(new Eomer(player1)); // G25
        deck.add(new Gandalf(player1)); // G26
        deck.add(new GreatShieldOfRohan(player1)); // G27
        deck.add(new Escape(player1)); // G29
        deck.add(new OrcGuard(player1)); // G30
        deck.add(new Concealment(player1)); // G33
        deck.add(new OrcWarriors(player1)); // G34
        deck.add(new Escape(player1)); // G35
        deck.add(new Gandalf(player1)); // G38
        deck.add(new Dodge(player1)); // G39
        deck.add(new LuckyStrike(player1)); //G40
        deck.add(new Glamdring(player1)); // G41
        deck.add(new OrcRaiders(player1)); // G42
        deck.add(new Erkenbrand(player1)); // G44
        deck.add(new OrcGuard(player1)); // G45
        deck.add(new Ford(player1)); // G50
        deck.add(new HalflingStrength(player1)); // G51
        deck.add(new OrcRaiders(player1)); // G52
        deck.add(new Bridge(player1)); // G55
        deck.add(new HalflingStealth(player1)); // G56
        deck.add(new Muster(player1)); // G59

        deck.add(new OrcWarriors(player1)); // G54
        deck.add(new Brigands(player1)); // G18
        deck.add(new Brigands(player1)); // G32
        deck.add(new Brigands(player1)); // G49
        deck.add(new WilliamWuluag(player1)); // G28
        deck.add(new OrcWatch(player1)); // G47
        deck.add(new OrcWatch(player1)); // G57
        deck.add(new OrcWatch(player1)); // G60
        deck.add(new ArouseMinions(player1)); // G16
        deck.add(new ArouseMinions(player1)); // G37
        deck.add(new ArouseMinions(player1)); // G58
        deck.add(new River(player1)); // G19
        deck.add(new River(player1)); // G48
        deck.add(new MinionsStir(player1)); // G36
        deck.add(new MinionsStir(player1)); // G46

        return deck;
    }

    public static List<Basic> defaultDeck2(Player player2) {
        List<Basic> deck = new ArrayList<>();
        
        // Adding characters

        // Adding objects

        // Adding resources

        // Adding hazards

        return deck;
    }

    public StarterDeck() {
        // Constructor
    }

    // PERSONAJES GANDALF
    /**
     * G01 TW009 Personaje Aragorn II
     */
    public static class AragornII extends Character {
        public AragornII(Player player) {
            super(player, Race.DUNEDAIN, Locations.Bree.class, 3, 9,
                    Set.of(Skills.WARRIOR, Skills.SCOUT, Skills.RANGER), 0, 9, 6);
        }
    }

    /**
     * G02 TW023 Personaje Boromir II
     */
    public static class BoromirII extends Character {
        public BoromirII(Player player) {
            super(player, Race.DUNEDAIN, Locations.MinasTirith.class, 1, 4, Set.of(Skills.WARRIOR), 1, 7, 6);
        }
    }

    /**
     * G04 TW054 Personaje Kili
     */
    public static class Kili extends Character {
        public Kili(Player player) {
            super(player, Race.DWARF, Locations.BlueMountainDwarfHold.class, 0, 3, Set.of(Skills.WARRIOR, Skills.SCOUT),
                    1, 8, 3);
        }
    }

    /**
     * G05 TW057 Personaje Merry
     */
    public static class Merry extends Character {
        public Merry(Player player) {
            super(player, Race.HOBBIT, Locations.BagEnd.class, 1, 4, Set.of(Skills.SCOUT), -2, 9, 1);
        }
    }

    /**
     * G17 TW016 Personaje Beregond
     */
    public static class Beregond extends Character {
        public Beregond(Player player) {
            super(player, Race.DUNEDAIN, Locations.MinasTirith.class, 0, 2, Set.of(Skills.WARRIOR), 1, 8, 4);
        }
    }

    /**
     * G22 TW037 Personaje Faramir
     */
    public static class Faramir extends Character {
        public Faramir(Player player) {
            super(player, Race.DUNEDAIN, Locations.HennethAnnun.class, 1, 5, Set.of(Skills.WARRIOR, Skills.RANGER), 0,
                    8, 5);
        }
    }

    /**
     * G25 TW034 Personaje Éomer
     */
    public static class Eomer extends Character {
        public Eomer(Player player) {
            super(player, Race.MAN, Locations.Edoras.class, 0, 3, Set.of(Skills.WARRIOR, Skills.RANGER), 0, 8, 3);
        }
    }

    /**
     * G26 TW002 Personaje Gandalf
     * G38 TW002 Personaje Gandalf
     */
    public static class Gandalf extends Character {
        public Gandalf(Player player) {
            super(player, Race.WIZARD, Locations.Rivendell.class, 10, 0,
                    Set.of(Skills.WARRIOR, Skills.SCOUT, Skills.SAGE, Skills.DIPLOMAT), -1, 9, 6);
        }
    }

    /**
     * G44 TW036 Personaje Erkenbrand
     */
    public static class Erkenbrand extends Character {
        public Erkenbrand(Player player) {
            super(player, Race.MAN, Locations.Edoras.class, 2, 4, Set.of(Skills.WARRIOR), 0, 6, 5);
        }
    }

    // OBJETOS GANDALF
    public static class ShieldOfIronBoundAsh extends Item {
        public ShieldOfIronBoundAsh(Player player) {
            super(player, 1, 0, 0, 1, 8, 0, ItemType.MINOR_ITEM);
        }
    }

    public static class ElvenCloak extends Item {
        public ElvenCloak(Player player) {
            super(player, 1, 0, 0, 0, 0, 0, ItemType.MINOR_ITEM);
        }
    }

    public static class ScrollOfIsildur extends Item {
        public ScrollOfIsildur(Player player) {
            super(player, 3, 4, 0, 0, 0, 0, ItemType.GREATER_ITEM);
        }
    }

    public static class GreatShieldOfRohan extends Item {
        public GreatShieldOfRohan(Player player) {
            super(player, 2, 2, 0, 0, 2, 9, ItemType.MAJOR_ITEM);
        }
    }

    public static class Glamdring extends Item {
        public Glamdring(Player player) {
            super(player, 1, 2, 0, 0, 0, 8, ItemType.MAJOR_ITEM);
        }
    }

    // RECURSOS DE GANDALF
    public static class Dodge extends Resource {
        public Dodge(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class LuckyStrike extends Resource {
        public LuckyStrike(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class TemperingFriendship extends Resource {
        public TemperingFriendship(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class Concealment extends Resource {
        public Concealment(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class HalflingStealth extends Resource {
        public HalflingStealth(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class HalflingStrength extends Resource {
        public HalflingStrength(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class Escape extends Resource {
        public Escape(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class Ford extends Resource {
        public Ford(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class Bridge extends Resource {
        public Bridge(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class Muster extends Resource {
        public Muster(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    // PERSONAJES SARUMAN
    /**
     * S01 TW046 Personaje Gimli
     */
    public static class Gimli extends Character {
        public Gimli(Player player) {
            super(player, Race.DWARF, Locations.IronHillDwarfHold.class, 2, 6, Set.of(Skills.WARRIOR, Skills.DIPLOMAT),
                    0, 8, 5);
        }
    }

    /**
     * S02 TW055 Personaje Legolas
     */
    public static class Legolas extends Character {
        public Legolas(Player player) {
            super(player, Race.ELF, Locations.ThranduilsHalls.class, 2, 6, Set.of(Skills.WARRIOR, Skills.DIPLOMAT), 0,
                    8, 5);
        }
    }

    /**
     * S04 TW031 Personaje Elladan
     */
    public static class Elladan extends Character {
        public Elladan(Player player) {
            super(player, Race.ELF, Locations.Rivendell.class, 0, 4, Set.of(Skills.WARRIOR, Skills.RANGER), 0, 8, 5);
        }
    }

    /**
     * S05 TW063 Personaje Pippin
     */
    public static class Pippin extends Character {
        public Pippin(Player player) {
            super(player, Race.HOBBIT, Locations.BagEnd.class, 1, 4, Set.of(Skills.SCOUT), -2, 9, 1);
        }
    }

    /**
     * S19 TW005 Personaje Saruman
     * S32 TW005 Personaje Saruman
     */
    public static class Saruman extends Character {
        public Saruman(Player player) {
            super(player, Race.WIZARD, Locations.Isengard.class, 10, 0,
                    Set.of(Skills.SCOUT, Skills.RANGER, Skills.SAGE, Skills.DIPLOMAT), 0, 9, 6);
        }
    }

    /**
     * S23 TW008 Personaje Annalena
     */
    public static class Annalena extends Character {
        public Annalena(Player player) {
            super(player, Race.ELF, Locations.Edhellond.class, 0, 3, Set.of(Skills.SCOUT, Skills.SAGE), 0, 8, 3);
        }
    }

    /**
     * S36 TW013 Personaje Bardo el Arquero
     */
    public static class BardBowman extends Character {
        public BardBowman(Player player) {
            super(player, Race.MAN, Locations.LakeTown.class, 0, 2, Set.of(Skills.SCOUT), 0, 6, 3);
        }
    }

    /**
     * S42 TW024 Personaje Celeborn
     */
    public static class Celeborn extends Character {
        public Celeborn(Player player) {
            super(player, Race.ELF, Locations.Lorien.class, 1, 6, Set.of(Skills.WARRIOR, Skills.SAGE), 0, 9, 6);
        }
    }

    /**
     * S51 TW032 Personaje Elrohir
     */
    public static class Elrohir extends Character {
        public Elrohir(Player player) {
            super(player, Race.ELF, Locations.Rivendell.class, 0, 4, Set.of(Skills.WARRIOR, Skills.RANGER), 0, 8, 5);
        }
    }

    // OBJETOS SARUMAN
    public static class DaggerOfWesternesse extends Item {
        public DaggerOfWesternesse(Player player) {
            super(player, 1, 0, 0, 0, 1, 8, ItemType.MINOR_ITEM);
        }
    }

    public static class HauberkOfBrightMail extends Item {
        public HauberkOfBrightMail(Player player) {
            super(player, 1, 2, 0, 0, 0, 0, ItemType.MAJOR_ITEM);
        }
    }

    public static class Orcrist extends Item {
        public Orcrist(Player player) {
            super(player, 2, 4, 0, 0, 3, 9, ItemType.GREATER_ITEM);
        }
    }

    public static class SwordOfGondolin extends Item {
        public SwordOfGondolin(Player player) {
            super(player, 2, 4, 0, 0, 0, 0, ItemType.MAJOR_ITEM);
        }
    }

    // RECURSOS DE SARUMAN
    public static class Block extends Resource {
        public Block(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class RiskyBlow extends Resource {
        public RiskyBlow(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    public static class DarkQuarrels extends Resource {
        public DarkQuarrels(Player player) {
            super(player, 0, 0, 0, 0, 0, 0, Type.SHORT_EVENT);
        }
    }

    // ADVERSIDADES DE GANDALF
    /**
     * G12 TW258 Adversidad Criatura Berto (Bûrat)
     */
    public static class BertBurat extends Hazard {
        public BertBurat(Player player) {
            super(player, Type.CREATURE, true);
        }
    }

    /**
     * G13 TW284 Adversidad Criatura Incursores Orcos
     * G42 TW284 Adversidad Criatura Incursores Orcos
     * G52 TW284 Adversidad Criatura Incursores Orcos
     */
    public static class OrcRaiders extends Hazard {
        public OrcRaiders(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G14 TW281 Adversidad Criatura Guardia de Orcos
     * G30 TW281 Adversidad Criatura Guardia de Orcos
     * G45 TW281 Adversidad Criatura Guardia de Orcos
     */
    public static class OrcGuard extends Hazard {
        public OrcGuard(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G15 TW286 Adversidad Criatura Guerreros Orcos
     * G34 TW286 Adversidad Criatura Guerreros Orcos
     * G54 TW286 Adversidad Criatura Guerreros Orcos
     */
    public static class OrcWarriors extends Hazard {
        public OrcWarriors(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G18 TW259 Adversidad Criatura Forajidos
     * G32 TW259 Adversidad Criatura Forajidos
     * G49 TW259 Adversidad Criatura Forajidos
     */
    public static class Brigands extends Hazard {
        public Brigands(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G28 TW302 Adversidad Criatura Guille (Wûluag)
     */
    public static class WilliamWuluag extends Hazard {
        public WilliamWuluag(Player player) {
            super(player, Type.CREATURE, true);
        }
    }

    /**
     * G47 TW287 Adversidad Criatura Centinelas Orcos
     * G57 TW287 Adversidad Criatura Centinelas Orcos
     * G60 TW287 Adversidad Criatura Centinelas Orcos
     */
    public static class OrcWatch extends Hazard {
        public OrcWatch(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * G16 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * G37 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * G58 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * S14 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * S37 TW306 Adversidad de Suceso Perturbar a los Lacayos
     * S59 TW306 Adversidad de Suceso Perturbar a los Lacayos
     */
    public static class ArouseMinions extends Hazard {
        public ArouseMinions(Player player) {
            super(player, Type.SHORT_EVENT, false);
        }
    }

    /**
     * G19 TW346 Adversidad de Suceso Río
     * G48 TW346 Adversidad de Suceso Río
     * S41 TW346 Adversidad de Suceso Río
     * S48 TW346 Adversidad de Suceso Río
     */
    public static class River extends Hazard {
        public River(Player player) {
            super(player, Type.SHORT_EVENT, false);
        }
    }

    /**
     * G36 TW338 Adversidad de Suceso Los Sirvientes se Agitan
     * G46 TW338 Adversidad de Suceso Los Sirvientes se Agitan
     */
    public static class MinionsStir extends Hazard {
        public MinionsStir(Player player) {
            super(player, Type.LONG_EVENT, false);
        }
    }

    // ADVERSIDADES DE SARUMAN
    /**
     * S10 TW300 Adversidad Criatura Huargos
     * S12 TW300 Adversidad Criatura Huargos
     * S30 TW300 Adversidad Criatura Huargos
     */
    public static class Wargs extends Hazard {
        public Wargs(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S11 TW304 Adversidad Criatura Lobos
     * S26 TW304 Adversidad Criatura Lobos
     * S28 TW304 Adversidad Criatura Lobos
     */
    public static class Wolves extends Hazard {
        public Wolves(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S13 TW267 Adversidad Criatura Fantasmas
     * S50 TW267 Adversidad Criatura Fantasmas
     */
    public static class Ghosts extends Hazard {
        public Ghosts(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S20 TD095 Adversidad Criatura Arañas Menores
     * S31 TD095 Adversidad Criatura Arañas Menores
     * S46 TD095 Adversidad Criatura Arañas Menores
     */
    public static class LesserSpiders extends Hazard {
        public LesserSpiders(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S21 TW268 Adversidad Criatura Necrófagos
     * S57 TW268 Adversidad Criatura Necrófagos
     */
    public static class Ghouls extends Hazard {
        public Ghouls(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S24 TW273 Adversidad Criatura Ucorno
     * S38 TW273 Adversidad Criatura Ucorno
     */
    public static class Huorn extends Hazard {
        public Huorn(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S34 TW257 Adversidad Criatura Tumulario
     * S52 TW257 Adversidad Criatura Tumulario
     */
    public static class BarrowWights extends Hazard {
        public BarrowWights(Player player) {
            super(player, Type.CREATURE, false);
        }
    }

    /**
     * S29 TW361 Adversidad de Suceso Alba de Guerra
     * S54 TW361 Adversidad de Suceso Alba de Guerra
     */
    public static class WakeOfWar extends Hazard {
        public WakeOfWar(Player player) {
            super(player, Type.LONG_EVENT, false);
        }
    }
}
