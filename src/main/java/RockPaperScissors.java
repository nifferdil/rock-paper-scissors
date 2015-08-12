import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.Random;


public class RockPaperScissors {
  public static void main (String[] args ) {

    String layout =  "templates/GameTemplate.vtl";

    get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/HomePage.vtl");

         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    get("/homepage", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView(model, "templates/HomePage.vtl");
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/detector.vtl");

      //  Random computerRandomInput = new Random();
      //  int computerInput = (int)(Math.random()*3);

       String userOneInput = request.queryParams("userOneInput");
       String userTwoInput = "1";

       String result = checkWinner(userOneInput, userTwoInput);
       model.put("result", result);
      // model.put("detector", request.queryParams("detector"));
       return new ModelAndView(new HashMap(), layout);
     }, new VelocityTemplateEngine());
  }

  public static String checkWinner(String userOneInput, String userTwoInput) {
    // userOne = "0", userTwo = "1"

    int oneInput = Integer.parseInt(userOneInput);
    int twoInput = Integer.parseInt(userTwoInput);

    // oneInput 0, twoInput, 1

    int rock = 0;
    int paper = 1;
    int scissors = 2;

    // tie
    // Rock beats scissors
    // Scissors beats paper
    // paper beats rock

    // rock loses to paper
    // scissors loses to rock
    // paper loses to scissors

    if (oneInput == 0) {
      return "You entered rock";
    } else if (oneInput == 0 && twoInput == 2) {
      return "Rock crushes scissors.";
    } else {
      return "Oops";
    }



    // if ( oneInput && twoInput ) {
    //
    //   if ( playerOneInput == 0 && playerTwoInput == 0 ) {
    //     return "Rock-rock!. Tie!";
    //   }
    //   else if (( playerOneInput == 2 && playerTwoInput == 1 ) ||
    //       ( playerOneInput == 1 && playerTwoInput == 2)) {
    //         return "Paper wins!";
    //   }
    //   else if ((( playerOneInput == 1) && (playerTwoInput == 2 )) ||
    //       ((playerOneInput == 2) && (playerTwoInput == 1))) {
    //         return "Rock crushes scissors!";
    //   }
    //   else ((( playerOneInput == 0) && (playerTwoInput == 2 )) ||
    //        ((playerOneInput == 2) && (playerTwoInput == 0))) {
    //         return "Rock crushes scissors!";
    //   }
    // }
    //
    // else if {
    //
    //    if (( playerOneInput== 0 && computerRandomInput == 0 )) {
    //     //System.out.println("Rock-rock!. Tie!\n");
    //     return "Rock-rock!. Tie!";
    //     }
    //
    //   else if (( playerOneInput == 0 && computerRandomInput == 1 ) ||
    //     ( playerOneInput == 1 && computerRandomInput == 0 )) {
    //     //System.out.println("Paper covers rock.\n");
    //     return "Paper wins.";
    //     //userTwoScore++;
    //     }
    //
    //   else if (( playerOneInput == 1 && computerRandomInput == 2 )||
    //     ( playerOneInput == 2 && computerRandomInput == 1 )) {
    //     //System.out.println("Rock meets scissors.\n");
    //     return "Rock crushes scissors!";
    //     //userOneScore++;
    //     }
    //   else {
    //     return "Play again.";
    //   }
    // }
  }

}
