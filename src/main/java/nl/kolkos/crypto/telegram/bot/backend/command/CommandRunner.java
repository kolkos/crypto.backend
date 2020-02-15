package nl.kolkos.crypto.telegram.bot.backend.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.service.RestClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class CommandRunner {

    private Command command;
    private final RestClient restClient;


    public void setCommand(Command command) {
        this.command = command;
    }

    public String run() {
        String url = command.execute();
        String response = restClient.callUrl(url);

        log.info("Calling url: {}", url);
        log.info("Response from Domoticz:\n{}", response);

        return response;
    }

}
