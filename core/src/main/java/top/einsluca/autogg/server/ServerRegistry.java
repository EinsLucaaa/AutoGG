package top.einsluca.autogg.server;

import java.util.ArrayList;
import java.util.List;

public class ServerRegistry {

    private final List<ServerConfiguration> servers = new ArrayList<>();

    public ServerRegistry() {
        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("gommehd.net", "play.gommehd.net", "gommehd.de"),
                        List.of("-= Statistiken dieser Runde =-", "-= Statistics of this game =-", "hat die PartyGames gewonnen!"),
                        List.of(":")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("skydinse.de", "play.skindinse.de", "skydinse.tk", "skydinse.net"),
                        List.of("Statistics of the game:", "Statistiken der Runde:"),
                        List.of("|")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("cytooxien.de", "cytooxien.net"),
                        List.of("Statistiken dieser Runde:", "Statistics of the game:"),
                        List.of("-")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("antiac.net", "antiac.eu", "antiac.de", "antiac.us", "play.antiac.net", "play.antiac.us"),
                        List.of("Overview of the round", "Rundenübersicht"),
                        List.of("»")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("neruxvace.de", "neruxvace.net", "nerux.net", "thevace.net", "neruxvase.net", "neruxvase.de"),
                        List.of("Das Spiel ist beendet!"),
                        List.of("MVP", "VIP", "PLAYER", "MVP+", ":")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("cafestu.be"),
                        List.of("has won the game", "hat das Spiel gewonnen", "har vunnet spillet", "gagné le jeu"),
                        List.of("●")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("mccisland.net", "play.mccisland.net"),
                        List.of("Game Over!"),
                        List.of(":")
                )
        );

        this.servers.add(
                new ServerConfigurationImpl(
                        List.of("staymc.net", "play.staymc.net"),
                        List.of("hat die Runde gewonnen!"),
                        List.of(":")
                )
        );

    }

    public List<ServerConfiguration> getServers() {
        return this.servers;
    }


}
