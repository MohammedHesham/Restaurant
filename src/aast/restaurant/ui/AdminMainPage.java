package aast.restaurant.ui;

import aast.restaurant.model.User;
import aast.restaurant.service.UserService;
import aast.restaurant.service.impl.UserServiceImpl;
import aast.restaurant.util.ImageUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminMainPage {

    private final UserService userService;
    private final ImageView profileImage;

    public AdminMainPage() {
        userService = new UserServiceImpl();
        profileImage = ImageUtil.getProfileIcon();

        if (profileImage != null) {
            profileImage.setFitHeight(200);
            profileImage.setFitWidth(200);
        }

    }

    public void displayMainPage(Stage stage) {

        // set title for the stage
        stage.setTitle("Admin");

        // create a tabpane
        TabPane tabpane = new TabPane();


        Tab tab1 = new Tab("Users");
        tab1.setClosable(false);
//        ObservableList<User> data = FXCollections.observableArrayList();
//        data.addAll(userService.getAllUsers());
//
//        final ListView<User> listView = new ListView<>(data);
//        listView.setCellFactory(listView1 -> new CustomListCell());
//
//        StackPane root = new StackPane();
//        root.getChildren().add(listView);
//        tab1.setContent(root);

        Tab tab2 = new Tab("Items");
        tab2.setClosable(false);

        Tab tab3 = new Tab("Orders");
        tab3.setClosable(false);

        tabpane.getTabs().addAll(tab1, tab2, tab3);

        stage.getScene().setRoot(tabpane);
    }


//    private class CustomListCell extends ListCell<User> {
//        private final HBox content;
//        private final Text name;
//        private final Text price;
//
//        public CustomListCell() {
//            super();
//            name = new Text();
//            price = new Text();
//            VBox vBox = new VBox(name, price);
//            content = new HBox(profileImage, vBox);
//            content.setSpacing(10);
//        }
//
//        @Override
//        protected void updateItem(User item, boolean empty) {
//            super.updateItem(item, empty);
//            if (item != null && !empty) { // <== test for null item and empty parameter
//                name.setText(item.getUsername());
//                price.setText(String.format("%d $", 10));
//                setGraphic(content);
//            } else {
//                setGraphic(null);
//            }
//        }
//    }

}
