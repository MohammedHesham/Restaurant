package aast.restaurant.ui;

import aast.restaurant.model.Item;
import aast.restaurant.model.User;
import aast.restaurant.service.UserService;
import aast.restaurant.service.impl.RestaurantServiceImpl;
import aast.restaurant.service.impl.UserServiceImpl;
import aast.restaurant.util.ImageUtil;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class AdminMainPage {

    private final UserService userService;
    private final RestaurantServiceImpl restaurantService;

    public AdminMainPage() {
        userService = new UserServiceImpl();
        restaurantService = new RestaurantServiceImpl();

    }

    public void displayMainPage(Stage stage) {

        // set title for the stage
        stage.setTitle("Admin");

        // create a tabpane
        TabPane tabpane = new TabPane();


        Tab tab1 = new Tab("Users");
        tab1.setClosable(false);
        List<User> users = userService.getAllUsers();
        List<Item> items = restaurantService.getMenuItems();
        ListView<String> names = new ListView<>();
        for (User user : users) {
            names.getItems().add(user.getUsername());
        }

        ListView<User> usersListView = new ListView<>();
        usersListView.getItems().addAll(users);
        fillUsersTabContent(usersListView);
        tab1.setContent(usersListView);


        ListView<Item> itemListView = new ListView<>();
        itemListView.getItems().addAll(items);
        fillItemsTabContent(itemListView);
        Tab tab2 = new Tab("Items");
        tab2.setClosable(false);
        tab2.setContent(itemListView);

        Tab tab3 = new Tab("Orders");
        tab3.setClosable(false);

        tabpane.getTabs().addAll(tab1, tab2, tab3);

        stage.getScene().setRoot(tabpane);
    }


    private void fillUsersTabContent(ListView<User> listView) {
        listView.setCellFactory(param -> new ListCell<User>() {

            private final ImageView imageView = ImageUtil.getProfileIcon();
            private final Label label = new Label();
            private final Label label2 = new Label();
            private final VBox vBox = new VBox(5);
            private final BorderPane bp = new BorderPane(vBox, null, null, null, imageView);

            @Override
            protected void updateItem(User item, boolean empty) {
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if (vBox.getChildren().isEmpty())
                        vBox.getChildren().addAll(label, label2);
                    label.setText(item.getUsername());
                    Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 16);
                    label.setFont(font);

                    label2.setText(item.getEmail());
                    setGraphic(bp);
                }
            }
        });
    }

    private void fillItemsTabContent(ListView<Item> listView) {
        listView.setCellFactory(param -> new ListCell<Item>() {

            private ImageView imageView = null;
            private final Label label = new Label();
            private final Text label2 = new Text();
            private final VBox vBox = new VBox(5);
            private final BorderPane bp = new BorderPane(vBox, null, null, null, imageView);

            @Override
            protected void updateItem(Item item, boolean empty) {
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if (vBox.getChildren().isEmpty())
                        vBox.getChildren().addAll(label, label2);
                    label.setText(item.getName());
                    imageView = ImageUtil.toImageView(item.getItemId() + ".png");
                    Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 16);

                    label.setFont(font);
                    label2.setText(item.getDescription());
                    label2.setWrappingWidth(200);

                    setGraphic(bp);
                }
            }
        });
    }

}
