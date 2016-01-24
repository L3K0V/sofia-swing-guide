package bg.lindyhop.controllers;

import bg.lindyhop.entities.AuthToken;
import bg.lindyhop.entities.GuideItem;
import bg.lindyhop.network.AuthTokenService;
import bg.lindyhop.network.Config;
import bg.lindyhop.network.GuideService;
import bg.lindyhop.network.ServiceGenerator;

/**
 * Created by lekov on 1/24/16.
 */
public class GuideController {

    private static GuideController instance;

    public static GuideController getInstance() {

        if (instance == null) {
            instance = new GuideController();
        }

        return instance;
    }

    public GuideItem loadGuide() {

        AuthTokenService tokenService = ServiceGenerator.createService(AuthTokenService.class,
                Config.CLIENT_ID, Config.CLIENT_SECRET);

        AuthToken token = tokenService.obtainToken(Config.GRANT_TYPE);

        GuideService service = ServiceGenerator.createServiceWithDeserializer(GuideService.class, token);

        return service.listGuideItems(1);
    }

}
