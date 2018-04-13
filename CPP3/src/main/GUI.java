/**
 *
 */
package main;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import object.shop.Shop;
import object.Constants;

/**
 * This class represent a View path of MVC-pattern.
 */
public class GUI {

    /**
     * Property of class GUI.
     */
    private Label cashStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label amountStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label incomeStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label productNameLabel;

    /**
     * @see GUI#cashStatus
     */
    private Label quantityInfoLabel;

    /**
     * @see GUI#cashStatus
     */
    private Label priceInfoLabel;

    /**
     * @see GUI#cashStatus
     */
    private Label handStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label mainProductStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label featureNameStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label featureStatus;

    /**
     * @see GUI#cashStatus
     */
    private Label packetQuantityStatus;

    /**
     * @see GUI#cashStatus
     */
    private Button btnInventory;

    /**
     * @see GUI#cashStatus
     */
    private Button btnBuy;

    /**
     * @see GUI#cashStatus
     */
    private Button btnPutToCart;

    /**
     * @see GUI#cashStatus
     */
    private Button btnTakeProduct;

    /**
     * @see GUI#cashStatus
     */
    private Button btnLayOutHand;

    /**
     * @see GUI#cashStatus
     */
    private Button btnLayOut;

    /**
     * @see GUI#cashStatus
     */
    private Button btnChangeRange;

    /**
     * @see GUI#cashStatus
     */
    private final Button btnPutToPacket;

    /**
     * @see GUI#cashStatus
     */
    private final Button btnGiveOutPacket;

    /**
     * @see GUI#cashStatus
     */
    private Button btnConsume;

    /**
     * @see GUI#cashStatus
     */
    private ComboBox<String> productCombo;

    /**
     * @see GUI#cashStatus
     */
    private ComboBox<String> mainProductCombo;

    /**
     * @see GUI#cashStatus
     */
    private VBox cartBox;

    /**
     * @see GUI#cashStatus
     */
    private VBox productBox;

    /**
     * @see GUI#cashStatus
     */
    private VBox shopBox;

    /**
     * @see GUI#cashStatus
     */
    private VBox productHandBox;

    /**
     * @see GUI#cashStatus
     */
    private final VBox packetBox;

    /**
     * @see GUI#cashStatus
     */
    private VBox mainProductBox;

    /**
     * @see GUI#cashStatus
     */
    private boolean isPressed = false;


    /**
     * @param root - pane to which the elements are attached
     * @param shop - give information that need to fill interface
     */
    //Check:OFF: MagicNumber|MethodLength
    public GUI(final BorderPane root, final Shop shop) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        root.setCenter(gridPane);

        //Buyer
        VBox buyerBox = new VBox();

        Text buyerText = new Text("Покупатель");
        buyerText.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        buyerBox.getChildren().add(buyerText);

        cashStatus = new Label();
        HBox cashBox = addStatus("Деньги: ", cashStatus);
        cashStatus.setText(Integer.toString(Constants.CASH));
        buyerBox.getChildren().add(cashBox);

        btnInventory = new Button("Открыть инвентарь");
        btnInventory.setPrefWidth(130);
        buyerBox.getChildren().add(btnInventory);

        btnBuy = new Button("Купить товар");
        btnBuy.setPrefWidth(130);
        buyerBox.getChildren().add(btnBuy);

        btnPutToCart = new Button("Положить в тележку");
        btnPutToCart.setPrefWidth(130);
        buyerBox.getChildren().add(btnPutToCart);

        btnTakeProduct = new Button("Взять товар");
        btnTakeProduct.setPrefWidth(130);
        buyerBox.getChildren().add(btnTakeProduct);

        buyerBox.setSpacing(7);
        buyerBox.setPadding(new Insets(0, 15, 0, 0));
        gridPane.add(buyerBox, 0, 0);

        //Cart
        cartBox = new VBox();

        Text cartText = new Text("Тележка");
        cartText.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        cartBox.getChildren().add(cartText);

        amountStatus = new Label();
        HBox amountBox = addStatus("Оставшийся объём: ", amountStatus);
        amountStatus.setText("10");
        cartBox.getChildren().add(amountBox);

        btnLayOut = new Button("Выложить товар");
        btnLayOut.setPrefWidth(120);
        cartBox.getChildren().add(btnLayOut);

        cartBox.setSpacing(7);
        cartBox.setPadding(new Insets(0, 15, 0, 7));
        gridPane.add(cartBox, 2, 0);

        //shop
        shopBox = new VBox();

        Text shopText = new Text("Магазин");
        shopText.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        shopBox.getChildren().add(shopText);

        Label nameStatus = new Label();
        HBox nameBox = addStatus("Название: ", nameStatus);
        nameStatus.setText(shop.getName());
        shopBox.getChildren().add(nameBox);

        incomeStatus = new Label();
        HBox incomeBox = addStatus("Прибыль: ", incomeStatus);
        shopBox.getChildren().add(incomeBox);

        btnChangeRange = new Button("Добавить товар");
        btnChangeRange.setPrefWidth(110);
        shopBox.getChildren().add(btnChangeRange);

        shopBox.setSpacing(5);
        shopBox.setPadding(new Insets(0, 15, 0, 7));
        gridPane.add(shopBox, 6, 0);

        //products
        productBox = new VBox();
        Label productLabel = new Label("Товары");
        productLabel.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        productBox.getChildren().add(productLabel);

        Label wishLabel = new Label("Что вы хотите купить?");
        productBox.getChildren().addAll(wishLabel);

        productCombo = new ComboBox<>();
        productCombo.getItems().addAll("Хлеб", "Спички", "Молоко");
        productCombo.getSelectionModel().selectFirst();
        productBox.getChildren().add(productCombo);

        productNameLabel = new Label();
        HBox productNameBox = addStatus("Название: ", productNameLabel);
        productNameLabel.setText("Хлеб");
        quantityInfoLabel = new Label();
        HBox productQuantityBox = addStatus("Количество: ",
                quantityInfoLabel);
        priceInfoLabel = new Label();
        HBox productPriceBox = addStatus("Стоимость: ", priceInfoLabel);
        priceInfoLabel.setText("1.5");
        productBox.getChildren().addAll(productNameBox, productQuantityBox,
                productPriceBox);

        productBox.setPadding(new Insets(0, 15, 0, 7));
        productBox.setSpacing(7);
        gridPane.add(productBox, 4, 0);

        //Inventory
        productHandBox = new VBox();

        Text productHandText = new Text("Товар в руках");
        productHandText.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD,
                20));
        productHandBox.getChildren().add(productHandText);

        handStatus = new Label();
        HBox handBox = addStatus("В руках: ", handStatus);
        handStatus.setText("");
        productHandBox.getChildren().add(handBox);

        btnLayOutHand = new Button("Выложить товар");
        btnLayOutHand.setPrefWidth(120);
        productHandBox.getChildren().add(btnLayOutHand);

        productHandBox.setSpacing(7);
        productHandBox.setPadding(new Insets(0, 15, 0, 7));
        gridPane.add(productHandBox, 2, 0);
        productHandBox.setVisible(false);

        //Packet
        packetBox = new VBox();

        Text packetText = new Text("Пакет");
        packetText.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        packetBox.getChildren().add(packetText);

        packetQuantityStatus = new Label();
        HBox packetQuantityBox = addStatus("Количество: ",
                packetQuantityStatus);
        packetBox.getChildren().add(packetQuantityBox);

        btnPutToPacket = new Button("Положить в пакет");
        btnPutToPacket.setPrefWidth(120);
        btnGiveOutPacket = new Button("Достать из пакета");
        btnGiveOutPacket.setPrefWidth(120);

        packetBox.getChildren().addAll(btnPutToPacket, btnGiveOutPacket);

        packetBox.setSpacing(7);
        packetBox.setPadding(new Insets(0, 15, 0, 7));
        gridPane.add(packetBox, 4, 0);
        packetBox.setVisible(false);

        //Bought products
        mainProductBox = new VBox();

        Text mainProductText = new Text("Купленные \nтовары");
        mainProductText.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 20));
        mainProductBox.getChildren().add(mainProductText);

        mainProductCombo = new ComboBox<>();
        mainProductCombo.getItems().addAll("Хлеб", "Спички", "Молоко");
        mainProductCombo.getSelectionModel().selectFirst();
        mainProductBox.getChildren().add(mainProductCombo);

        mainProductStatus = new Label();
        HBox mainProductQuantityBox = addStatus("Количество: ",
                mainProductStatus);
        mainProductBox.getChildren().add(mainProductQuantityBox);

        HBox featureBox = new HBox();
        featureNameStatus = new Label("Вкус: ");
        featureNameStatus.setFont(Font.font("Tahoma", FontPosture.ITALIC, 12));
        featureStatus = new Label("3.4");
        featureStatus.setFont(Font.font("Tahoma", FontPosture.ITALIC, 12));
        featureBox.getChildren().addAll(featureNameStatus, featureStatus);
        mainProductBox.getChildren().add(featureBox);

        btnConsume = new Button("Съесть");
        btnConsume.setPrefWidth(80);
        mainProductBox.getChildren().add(btnConsume);

        mainProductBox.setSpacing(7);
        mainProductBox.setPadding(new Insets(0, 15, 0, 7));
        gridPane.add(mainProductBox, 6, 0, 1, 1);
        mainProductBox.setVisible(false);

        final Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.VERTICAL);
        separator1.setValignment(VPos.CENTER);
        separator1.setMinWidth(4);
        separator1.setStyle("-fx-background-color: #3d3847;");
        gridPane.add(separator1, 1, 0);

        final Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        separator2.setValignment(VPos.CENTER);
        separator2.setMinWidth(4);
        separator2.setStyle("-fx-background-color: #3d3847;");
        gridPane.add(separator2, 3, 0);

        final Separator separator3 = new Separator();
        separator3.setOrientation(Orientation.VERTICAL);
        separator3.setValignment(VPos.CENTER);
        separator3.setMinWidth(4);
        separator3.setStyle("-fx-background-color: #3d3847;");
        gridPane.add(separator3, 5, 0);
    }

    /**
     * This method create 2 connected in one line labels and put them to pane.
     * @param name in which will change information.
     * @param status that will put to field.
     * @return HBox - result pane.
     */
    public HBox addStatus(final String name, final Label status) {
        HBox statusField = new HBox();
        Label nameLabel = new Label(name);
        nameLabel.setFont(Font.font("Tahoma", FontPosture.ITALIC, 12));
        statusField.getChildren().add(nameLabel);
        status.setFont(Font.font("Tahoma", FontPosture.ITALIC, 12));
        status.setText("0");
        statusField.getChildren().add(status);

        return statusField;
    }
    //Check:ON: MagicNumber|MethodLength

    /**
     * This method output a information in short message.
     * @param label in which will change information.
     * @param value that will put to field.
     */
    public void updateData(final Label label, final int value) {
        Integer temp = value;
        label.setText(temp.toString());
    }

    /**
     * @see GUI#updateData(Label, int)
     * @param label in which will change information.
     * @param value that will put to field.
     */
    public void updateData(final Label label, final float value) {
        Float temp = value;
        label.setText(temp.toString());
    }

    /**
     * This method output a information in short message.
     * @param text - message to be displayed.
     */
    public static void warning(final String text) {
        Alert alert = new Alert(Alert.AlertType.NONE, text, ButtonType.OK);
        alert.setTitle("Предупреждение");
        alert.showAndWait();
    }

    /**
     * Property of class GUI.
     * @return in method's name class object
     */
    public Label getCashStatus() {
        return cashStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getAmountStatus() {
        return amountStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getFeatureNameStatus() {
        return featureNameStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getFeatureStatus() {
        return featureStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getHandStatus() {
        return handStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getIncomeStatus() {
        return incomeStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getMainProductStatus() {
        return mainProductStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getPriceInfoLabel() {
        return priceInfoLabel;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getProductNameLabel() {
        return productNameLabel;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getQuantityInfoLabel() {
        return quantityInfoLabel;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Label getPacketQuantityStatus() {
        return packetQuantityStatus;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnPutToPacket() {
        return btnPutToPacket;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnGiveOutPacket() {
        return btnGiveOutPacket;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnBuy() {
        return btnBuy;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnChangeRange() {
        return btnChangeRange;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnConsume() {
        return btnConsume;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnInventory() {
        return btnInventory;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnLayOutHand() {
        return btnLayOutHand;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnLayOut() {
        return btnLayOut;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnPutToCart() {
        return btnPutToCart;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public Button getBtnTakeProduct() {
        return btnTakeProduct;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public ComboBox<String> getMainProductCombo() {
        return mainProductCombo;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public ComboBox<String> getProductCombo() {
        return productCombo;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public VBox getCartBox() {
        return cartBox;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public VBox getProductBox() {
        return productBox;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public VBox getMainProductBox() {
        return mainProductBox;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public VBox getPacketBox() {
        return packetBox;
    }

    /**
     * @see GUI#getCashStatus
     * @return in method's name class object
     */
    public VBox getShopBox() {
        return shopBox;
    }

    /**
     * Property of GUI class.
     * @return VBox's class object.
     */
    public VBox getProductHandBox() {
        return productHandBox;
    }

    /**
     * Property of GUI class.
     * @return boolean value.
     */
    public boolean isPressed() {
        return isPressed;
    }

    /**
     * Property of GUI class.
     * @param pressed - state of button.
     */
    public void setPressed(final boolean pressed) {
        isPressed = pressed;
    }
}
