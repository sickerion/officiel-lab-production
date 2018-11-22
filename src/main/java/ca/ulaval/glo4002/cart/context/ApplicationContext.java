package ca.ulaval.glo4002.cart.context;

public class ApplicationContext {



    public void apply() {
        String store = System.getProperty("store");
        String promo = System.getProperty("promo");
        String mode = System.getProperty("mode");

        if (store.equals("xml")) {
            new XmlPersistenceContext().apply();
        } else if (store.equals("hibernate")) {
            new HibernatePersistenceContext().apply();
        } else if (store.equals("memory")) {
            new InMemoryPersistenceContext().apply();
        } else {
            throw new RuntimeException(
                    "No story parameter provided. Requires -D" + store + "=xml|memory|hibernate");
        }

        if (promo.equals("true")) {
            new PromoContext().apply();
        } else {
            new NoPromoContext().apply();
        }

        if (mode.equals("demo")) {
            new DemoPrefillContext().apply();
        }
    }
}
