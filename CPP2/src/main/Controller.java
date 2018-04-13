package main;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import object.Buyer;
import object.product.Bread;
import object.product.Match;
import object.product.Product;
import object.shop.Shop;
import object.Constants;

/**
 * This class represent a Controller path of MVC pattern.
 */
public class Controller {

    /**
     * This constructor connects Controller with View (class GUI).
     * @param gui - interface.
     * @param shop - first interacting object.
     * @param buyer - second interacting object.
     */
    public Controller(final GUI gui, final Shop shop, final Buyer buyer) {
        buttonInventoryAction(gui);
        buttonChangeRangeAction(gui, shop);
        buttonTakeProductAction(gui, shop, buyer);
        buttonPutToCartAction(gui, shop, buyer);
        productComboAction(gui, shop);
        buttonLayOutHandAction(gui, shop, buyer);
        buttonLayOutAction(gui, shop);
        buttonBuyAction(gui, shop, buyer);
        mainProductComboAction(gui, buyer);
        buttonConsumeAction(gui, buyer);
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     */
    private void buttonInventoryAction(final GUI gui) {
        gui.getBtnInventory().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                boolean check = gui.isPressed();
                if (!check) {
                    gui.setPressed(true);
                    gui.getBtnInventory().setText("Закрыть инвентарь");
                } else {
                    gui.setPressed(false);
                    gui.getBtnInventory().setText("Открыть инвентарь");
                }
                gui.getCartBox().setVisible(check);
                gui.getProductBox().setVisible(check);
                gui.getShopBox().setVisible(check);
                gui.getProductHandBox().setVisible(!check);
                gui.getMainProductBox().setVisible(!check);
            }
        });
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param shop to get quantity of products and increment it.
     */
    private void buttonChangeRangeAction(final GUI gui, final Shop shop) {
        gui.getBtnChangeRange().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                int index =
                        gui.getProductCombo().getSelectionModel()
                                .getSelectedIndex();
                shop.addProduct(index);
                for (Product product : shop.getProductList()) {
                    if (product.getID() == index) {
                        gui.updateData(gui.getQuantityInfoLabel(),
                                product.getQuantity());
                        return;
                    }
                }
            }
        });
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param shop to get quantity of products and decrement it.
     * @param buyer to transfer him the product.
     */
    private void buttonTakeProductAction(final GUI gui, final Shop shop,
                                         final Buyer buyer) {
        gui.getBtnTakeProduct().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                int index = gui.getProductCombo().getSelectionModel()
                        .getSelectedIndex();
                if (transferProduct(shop, buyer, index)) {
                    if (index == Constants.BREAD_ID) {
                        Bread bread = new Bread();
                        Bread.reduceQuantity();
                        gui.updateData(gui.getQuantityInfoLabel(),
                                bread.getQuantity());
                        gui.getHandStatus().setText("хлеб");
                    } else {
                        Match match = new Match();
                        Match.reduceQuantity();
                        gui.updateData(gui.getQuantityInfoLabel(),
                                match.getQuantity());
                        gui.getHandStatus().setText("спички");
                    }
                }
            }
        });
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param shop to get acces to cart.
     * @param buyer give product to cart.
     */
    private void buttonPutToCartAction(final GUI gui, final Shop shop,
                                       final Buyer buyer) {
        gui.getBtnPutToCart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                boolean check = buyer.putToCart(shop.getCart());
                if (check) {
                    gui.updateData(gui.getAmountStatus(),
                            shop.getCart().getAmount());
                    gui.getHandStatus().setText("");
                }
            }
        });
    }

    /**
     * This method sets the action when the box is clicked.
     * @param gui - interface which contains box.
     * @param shop to get information about products.
     */
    private void productComboAction(final GUI gui, final Shop shop) {
        gui.getProductCombo().setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(final Event event) {
                int index = gui.getProductCombo().getSelectionModel()
                        .getSelectedIndex();
                gui.getProductNameLabel().setText(gui.getProductCombo()
                        .getValue());
                for (Product product : shop.getProductList()) {
                    if (product.getID() == index) {
                        Integer quantity = product.getQuantity();
                        gui.getQuantityInfoLabel()
                                .setText(quantity.toString());
                        Float price = product.getPrice();
                        gui.getPriceInfoLabel().setText(price.toString());
                        return;
                    }
                }
            }
        });
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param shop to which transfer products.
     * @param buyer - who gives products.
     */
    private void buttonLayOutHandAction(final GUI gui, final Shop shop,
                                        final Buyer buyer) {
        gui.getBtnLayOutHand().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                if (buyer.getProductInHand() == null) {
                    GUI.warning("В руке ничего нет!");
                    return;
                }

                shop.getProduct().add(buyer.getProductInHand());
                Integer id = buyer.getProductInHand().getID();
                buyer.freeHand();

                if (id == gui.getProductCombo().getSelectionModel()
                        .getSelectedIndex()) {
                    gui.updateData(gui.getQuantityInfoLabel(),
                            shop.countQuantity(id));
                }
                if (id == Constants.BREAD_ID) {
                    Bread.incrementQuantity();
                } else {
                    Match.incrementQuantity();
                }

                gui.getHandStatus().setText("");
            }
        });
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param shop - who contains cart and others product (inner transfer).
     */
    private void buttonLayOutAction(final GUI gui, final Shop shop) {
        gui.getBtnLayOut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                if (shop.getCart().getProduct().size() == 0)  {
                    GUI.warning("Тележка пуста!");
                    return;
                }

                for (Product product : shop.getCart().getProduct()) {
                    if (product.getID() == Constants.BREAD_ID) {
                        Bread.incrementQuantity();
                        shop.getProduct().add(product);
                    } else {
                        Match.incrementQuantity();
                        shop.getProduct().add(product);
                    }
                }
                shop.getCart().getProduct().clear();

                shop.getCart().setAmount(Constants.CART_AMOUNT);
                gui.updateData(gui.getAmountStatus(), Constants.CART_AMOUNT);

                Integer id = gui.getProductCombo().getSelectionModel()
                        .getSelectedIndex();
                gui.updateData(gui.getQuantityInfoLabel(),
                        shop.countQuantity(id));
            }
        });
    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param shop gets money.
     * @param buyer gets products and gives the money.
     */
    private void buttonBuyAction(final GUI gui, final Shop shop,
                                 final Buyer buyer) {
        gui.getBtnBuy().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                boolean check = buyer.buyProduct(shop);
                if (check) {
                    gui.updateData(gui.getCashStatus(), buyer.getCash());
                    gui.updateData(gui.getIncomeStatus(), shop.getIncome());
                    gui.updateData(gui.getAmountStatus(),
                            Constants.CART_AMOUNT);
                    gui.updateData(gui.getFeatureStatus(),
                            new Bread().getTaste());

                    int countBread = 0;
                    int countMatch = 0;

                    for (Product product : buyer.getMainProduct()) {
                        if (product.getID() == Constants.BREAD_ID) {
                            countBread++;
                        } else {
                            countMatch++;
                        }
                    }

                    int id = gui.getMainProductCombo().getSelectionModel()
                            .getSelectedIndex();

                    if (id == Constants.BREAD_ID) {
                       gui.updateData(gui.getMainProductStatus(), countBread);
                    } else {
                       gui.updateData(gui.getMainProductStatus(), countMatch);
                    }
                }

            }
        });
    }

    /**
     * This method sets the action when the box is clicked.
     * @param gui - interface which contains box.
     * @param buyer gives information about received products
     */
    private void mainProductComboAction(final GUI gui, final Buyer buyer) {
        gui.getMainProductCombo().setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(final Event event) {
                int id = gui.getMainProductCombo().getSelectionModel()
                        .getSelectedIndex();
                int count = 0;

                for (Product product : buyer.getMainProduct()) {
                    if (product.getID() == id) {
                        count++;
                    }
                }

                gui.updateData(gui.getMainProductStatus(), count);
                if (id == Constants.BREAD_ID) {
                    gui.updateData(gui.getFeatureStatus(),
                            Constants.BREAD_TASTE);
                    gui.getFeatureNameStatus().setText("Вкус: ");
                    gui.getBtnConsume().setText("Съесть");
                } else {
                    gui.updateData(gui.getFeatureStatus(),
                            Constants.MATCH_LENGTH);
                    gui.getFeatureNameStatus().setText("Длина: ");
                    gui.getBtnConsume().setText("Зажечь");
                }
            }
        });

    }

    /**
     * This method sets the action when the button is clicked.
     * @param gui - interface which contains button.
     * @param buyer provides access to product.
     */
    private void buttonConsumeAction(final GUI gui, final Buyer buyer) {
        gui.getBtnConsume().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                int id = gui.getMainProductCombo().getSelectionModel()
                        .getSelectedIndex();
                String check = buyer.consume(id);
                if (check == null) {
                    GUI.warning("Сначала купите продукт!");
                } else {
                    gui.updateData(gui.getMainProductStatus(),
                            Integer.parseInt(gui.getMainProductStatus()
                                    .getText()) - 1);
                    GUI.warning(check);
                }
            }
        });
    }

    /**
     * This method transfer products between shop and buyer.
     * @param shop provides products that contain in cart.
     * @param buyer is receiver of products.
     * @param id of product.
     * @return status of operation.
     */
    public boolean transferProduct(final Shop shop,
                                       final Buyer buyer, final int id) {
        for (Product product : shop.getProduct()) {
            if (product.getID() == id) {
                if (!buyer.takeProduct(product)) {
                    return false;
                }
                shop.getProduct().remove(product);
                return true;
            }
        }
        GUI.warning("В магазине нет продуктов!");
        return false;
    }
}
