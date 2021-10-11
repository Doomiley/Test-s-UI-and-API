package models;

import api.UsersApi;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestApi {
      private UsersApi usersApi = new UsersApi();

      @Test
      public void testUserInfoResponseType() {
          User user = usersApi.getUser("Doomiley");
          SoftAssert softAssert = new SoftAssert();
          softAssert.assertEquals(user.getLogin(), "Doomiley");
          softAssert.assertEquals(user.getId(), Integer.valueOf(49987832));
          softAssert.assertAll();
      }

      @Test
      public void testUserInfoResponseNegative() {
          User user = usersApi.getUser("sdfsdfsd!sdfsdfsdfsdfthjkl;lkllk,lkjukmkj,kjm", 404);

    }
}



