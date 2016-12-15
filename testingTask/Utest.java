package testingTask;
import org.junit.Test;
import java.sql.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;
import junit.framework.Assert;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class Utest {

	DAOImpl nDAO = new DAOImpl(); 

	  
  @Mock
  Connection conn;
  @Mock
  PreparedStatement psmt;
  @InjectMocks
  DAOImpl newDAO= new DAOImpl();	
  
  @Test
  public void testProductCon(){
  Product p= new Product (1);
  Assert.assertEquals(1,p.getId());
  }
  @Test
 public void testsetType(){
	  Product p= new Product(1);
	  p.setType("Food");
	  Assert.assertEquals("Food", p.getType());	  
  }
  @Test
 public void testsetManufacturer(){
	  Product p= new Product(1);
	  p.setManufacturer("EDITA");
	  Assert.assertEquals("EDITA",p.getManufacturer());
 }
 @Test
 public void testsetProductionDate(){
	 Product p= new Product(1);
	  p.setProductionDate("Monday");
	  Assert.assertEquals("Monday",p.getProductionDate());
 }
@Test
 public void testsetExpiryDate(){
	 Product p= new Product(1);
	  p.setExpiryDate("Saturday");
	  Assert.assertEquals("Saturday",p.getExpiryDate());
 }
@Test
public void HappyTest2() throws SQLException, DAOException{
	  when(conn.prepareStatement(anyString())).thenReturn(psmt);

  	  Product p = new Product(1);
  	  newDAO.insertProduct(p);
  	  
  	  ArgumentCaptor<Integer> intcaptor = ArgumentCaptor.forClass(int.class); 
      verify(psmt, times(1)).setInt(anyInt(), intcaptor.capture());
      
      ArgumentCaptor<String> stringcaptor = ArgumentCaptor.forClass(String.class);
	  verify(psmt, times(4)).setString(anyInt(), stringcaptor.capture());
	//Assert.assertEquals(intcaptor.getAllValues().get(0).equals(1));
	  Assert.assertTrue(intcaptor.getAllValues().get(0).equals(1));
	  }
	

@Test
public void IntegrationTest() throws SQLException, DAOException{
	Product newp=new Product(7);
	newp.setType("Food");
	newp.setManufacturer("EDITA");
	newp.setProductionDate("2010-11-15 ");
	newp.setExpiryDate("2011-11-19 ");
	
	nDAO.insertProduct(newp);
	Assert.assertNotNull(nDAO.getProduct(7));
nDAO.deleteProduct(7);
Assert.assertNull(nDAO.getProduct(7));
}


@Test (expected = DAOException.class)
public void ExceptionCase() throws SQLException, DAOException{
	when(conn.prepareStatement(anyString())).thenReturn(psmt);
	when(psmt.executeUpdate()).thenThrow(new SQLException());
	Product p = new Product(1);
	newDAO.insertProduct(p);
	}

}
