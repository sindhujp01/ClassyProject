package com.niit.classybackend.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.AuthenticationDao;
import com.niit.classybackend.Dao.BillingaddressDao;
import com.niit.classybackend.Dao.CardDao;
import com.niit.classybackend.Dao.CartDao;
import com.niit.classybackend.Dao.CartItemDao;
import com.niit.classybackend.Dao.CategoryDao;
import com.niit.classybackend.Dao.OrderDao;
import com.niit.classybackend.Dao.OrderItemsDao;
import com.niit.classybackend.Dao.PayDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.ShippingaddressDao;
import com.niit.classybackend.Dao.SupplierDao;
import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.classybackend.DaoImpl.BillingaddressDaoImpl;
import com.niit.classybackend.DaoImpl.CardDaoImpl;
import com.niit.classybackend.DaoImpl.CartDaoImpl;
import com.niit.classybackend.DaoImpl.CartItemDaoImpl;
import com.niit.classybackend.DaoImpl.CategoryDaoImpl;
import com.niit.classybackend.DaoImpl.OrderDaoImpl;
import com.niit.classybackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.classybackend.DaoImpl.PayDaoImpl;
import com.niit.classybackend.DaoImpl.ProductDaoImpl;
import com.niit.classybackend.DaoImpl.ShippingaddressDaoImpl;
import com.niit.classybackend.DaoImpl.SupplierDaoImpl;
import com.niit.classybackend.DaoImpl.UserDaoImpl;
import com.niit.classybackend.model.Authentication;
import com.niit.classybackend.model.Billingaddress;
import com.niit.classybackend.model.Card;
import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.CartItem;
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Order;
import com.niit.classybackend.model.OrderItems;
import com.niit.classybackend.model.Pay;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.Shippingaddress;
import com.niit.classybackend.model.User1;
import com.niit.classybackend.model.supplier1;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContext {
	@Bean("dataSource") // create a object without new keyword
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/classy3");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category1.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(supplier1.class);
		sessionBuilder.addAnnotatedClass(User1.class);
		sessionBuilder.addAnnotatedClass(Billingaddress.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Shippingaddress.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("supplierDao")
    public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("billingaddressDao")
	public BillingaddressDao getBillingaddressDao(SessionFactory sessionFactory)
	{
		return new BillingaddressDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("shippingaddressDao")
	public ShippingaddressDao getShippingaddressDao(SessionFactory sessionFactory)
	{
		return new ShippingaddressDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cartItemDao")
	public CartItemDao getCartItemDao(SessionFactory sessionFactory)
	{
		return new CartItemDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory)
	{
		return new CardDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory)
	{
		return new PayDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("orderDao")
	public OrderDao getOrderDao(SessionFactory sessionFactory)
	{
		return new OrderDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory)
	{
		return new AuthenticationDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory)
	{
		return new OrderItemsDaoImpl(sessionFactory);
	}
}
