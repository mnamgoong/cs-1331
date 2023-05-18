//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Represents a problem space to base a startup around
 * @author Michelle Namgoong
 * @version 1.0
 */
public class StarterUpper extends Application {

    private ArrayList<StartUpIdea> ideas = new ArrayList<>();
    private File ideasFile = new File("ideas.txt");

    @Override
    public void start(Stage stage) {
        Label q1 = new Label("What is the problem? ");
        TextField problem = new TextField();
        Label q2 = new Label("Who is the target customer? ");
        TextField targetCustomer = new TextField();
        Label q3 = new Label("How badly does the customer NEED this problem fixed (1-10)? ");
        TextField customerNeed = new TextField();
        Label q4 = new Label("How many people do you know who might experience this problem? ");
        TextField knownPeopleWithProblem = new TextField();
        Label q5 = new Label("How big is the target market? ");
        TextField targetMarketSize = new TextField();
        Label q6 = new Label("Who are the competitors/existing solutions? ");
        TextField competitors = new TextField();

        Button addIdea = new Button();
        addIdea.setText("Add Idea");
        addIdea.setOnAction(addIdeaEvent -> {
                try {
                    //check if text fields are empty
                    if (problem.getText().isEmpty()
                            || targetCustomer.getText().isEmpty()
                            || customerNeed.getText().isEmpty()
                            || knownPeopleWithProblem.getText().isEmpty()
                            || targetMarketSize.getText().isEmpty()
                            || competitors.getText().isEmpty()) {
                        throw new NullPointerException();
                    }
                    //read text fields
                    String ideaProblem = problem.getText();
                    String ideaTargetCustomer = targetCustomer.getText();
                    int ideaCustomerNeed = Integer.parseInt(customerNeed.getText());
                    int ideaKnownPeopleWithProblem = Integer.parseInt(knownPeopleWithProblem.getText());
                    int ideaTargetMarketSize = Integer.parseInt(targetMarketSize.getText());
                    String ideaCompetitors = competitors.getText();
                    //check bounds of integers
                    if ((ideaCustomerNeed < 1 || ideaCustomerNeed > 10)
                            || ideaKnownPeopleWithProblem < 0
                            || ideaTargetMarketSize < 0) {
                        throw new NumberFormatException();
                    }
                    //create a new idea and add to the list
                    StartUpIdea newIdea = new StartUpIdea(ideaProblem, ideaTargetCustomer, ideaCustomerNeed,
                            ideaKnownPeopleWithProblem, ideaTargetMarketSize, ideaCompetitors);
                    ideas.add(newIdea);
                    problem.setText("");
                    targetCustomer.setText("");
                    customerNeed.setText("");
                    knownPeopleWithProblem.setText("");
                    targetMarketSize.setText("");
                    competitors.setText("");
                } catch (NullPointerException npe) {
                    Alert empty = new Alert(Alert.AlertType.ERROR);
                    empty.setTitle("Error");
                    empty.setHeaderText("Empty Field(s)");
                    empty.setContentText("One or more fields are empty. Please enter a response for each question.");
                    empty.showAndWait();
                } catch (NumberFormatException nfe) {
                    Alert invalidNum = new Alert(Alert.AlertType.ERROR);
                    invalidNum.setTitle("Error");
                    invalidNum.setHeaderText("Invalid Number");
                    invalidNum.setContentText("Please enter a valid positive integer for fields 3, 4, and 5.");
                    invalidNum.showAndWait();
                } catch (IllegalArgumentException iae) {
                    Alert invalid = new Alert(Alert.AlertType.ERROR);
                    invalid.setTitle("Error");
                    invalid.setHeaderText("Invalid Response");
                    invalid.setContentText("Please enter a valid response for each question.");
                    invalid.showAndWait();
                }
            });

        Button sort = new Button();
        sort.setText("Sort Ideas");
        sort.setOnAction(sortEvent -> {
                Collections.sort(ideas);
            });

        Button save = new Button();
        save.setText("Save Ideas");
        EventHandler<ActionEvent> handler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent saveEvent) {
                FileUtil.saveIdeasToFile(ideas, ideasFile);
            }
        };
        save.setOnAction(handler);

        Button reset = new Button();
        reset.setText("Reset Form");
        reset.setOnAction(resetEvent -> {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to reset the form?",
                        ButtonType.YES, ButtonType.NO);
                confirm.showAndWait();
                if (confirm.getResult() == ButtonType.YES) {
                    ideasFile.delete();
                    ideas.clear();
                    problem.setText("");
                    targetCustomer.setText("");
                    customerNeed.setText("");
                    knownPeopleWithProblem.setText("");
                    targetMarketSize.setText("");
                    competitors.setText("");
                }
            });

        HBox input1 = new HBox();
        input1.setAlignment(Pos.CENTER);
        input1.setSpacing(10);
        input1.getChildren().addAll(q1, problem);
        HBox input2 = new HBox();
        input2.setAlignment(Pos.CENTER);
        input2.setSpacing(10);
        input2.getChildren().addAll(q2, targetCustomer);
        HBox input3 = new HBox();
        input3.setAlignment(Pos.CENTER);
        input3.setSpacing(10);
        input3.getChildren().addAll(q3, customerNeed);
        HBox input4 = new HBox();
        input4.setAlignment(Pos.CENTER);
        input4.setSpacing(10);
        input4.getChildren().addAll(q4, knownPeopleWithProblem);
        HBox input5 = new HBox();
        input5.setAlignment(Pos.CENTER);
        input5.setSpacing(10);
        input5.getChildren().addAll(q5, targetMarketSize);
        HBox input6 = new HBox();
        input6.setAlignment(Pos.CENTER);
        input6.setSpacing(10);
        input6.getChildren().addAll(q6, competitors);
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        buttons.getChildren().addAll(addIdea, sort, save, reset);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(input1, input2, input3, input4, input5, input6, buttons);

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("Problem Ideation Form");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Main method where the JavaFX program is launched
     * @param args an array of command-line arguments (if applicable)
     */
    public static void main(String[] args) {
        launch(args);
    }

}
