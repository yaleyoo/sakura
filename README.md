# Sakura Hotel Booking System 
This system is developed for a start-up hotel company named Sakura Hotel to support their daily operation and enable customer to book online. Sakura Hotel is a hot-spring hotel and currently owns two buildings, and is considering to extend its business. 

## Live Demo
### [Sakura Hotel Booking System](https://www.yaleyoo.com/Sakura/) (This server shared the database with other webapps, if this one is down, please try backup server)
### [Sakura Hotel Booking System(Backup)](https://sakura-hotel.herokuapp.com/)
Note: a known bug in backup server is, in error page, servlet would trying to navigate the user into the referer page (previous page). But the uri in backup server is slightly different with the main server, that would makes the servlet regards the uri illegal.
However, it will not interference the process.

## Roles
- Customer
	- `Customer` can search for the available rooms based on his/her **check-in time** and **check-out time** and book the available room. After the order has been placed, `customer` can check his order in **user center**. In user center, `customer` can also cancel his order **at least 2 days in advance**.
- Staff
	- Receptionist
		- `Receptionist` can help customer to place the order. `Receptionist` can also modify the information of orders whose status are not **Finished**.
	- Manager
		- `Manager` can also help customer to place the order. `Manager` can modify the information of **all** history order, including **Finished** orders. `Manager` is able to manage the property information regarding **buildings** and **rooms**.

## Order Status
- Booking 
	- Order has been placed and the related room has been booked during the **check-in time** to **check-out time**, but the Customer hasn't checked in.
- Cancel
	- Order has been cancelled, the related room has been released.
- Active
	- Customer has checked in, but hasn't checked out yet.
- Finished
	- Customer has checked out, the order is completed.

## Test Senario
### Part 2 (Feature A):
> `Customer` can search for the available rooms based on his/her **check-in time** and **check-out time** and book the available room. After the order has been placed, `customer` can check his order in **user center**. In user center, `customer` can also cancel his order in **at least 2 days advance**.

1. Enter [Sakura Hotel Index Page](https://www.yaleyoo.com/Sakura)
2. Click **Customer** button on the right-top coner to login as a customer.
3. Click **Book a Room** button on the navibar or in the central of the page.
4. You would be navigated to the page which listed all of the rooms.
5. Fill the `Check In Time` and `Check Out Time` fields following the format:
	`yyyy-MM-dd hh:mm:ss`. For instance:
	| Check In Date | Check Out Date | 
	| -----------------|---------------------| 
	| 2018-11-06 10:00:00| 2018-11-08 17:00:00 |
![](https://s1.ax1x.com/2018/10/06/i8IRPA.png)
6. Select the building in the building dropdown list. Click **Search** button, a list of the available rooms would be shown up.
![](https://s1.ax1x.com/2018/10/06/i8IW8I.png)
7. Select a room, click the **Book** button to place the order. The details about the order would shows up. (This step is authorisaiton required, you have to login first, otherwise, you would be redirect into a permissionDenied page.)
In this step, check-out-time should after the check-in-time, also check-in-time should be a future time. If those requirements are fail to meet, an error message would shows up.
![](https://s1.ax1x.com/2018/10/06/i8I5Kf.png)
8. Check the details of the orders. If they are correc, click **confirm** button, your order. If the order is successfully placed, a successfully booked message would shows up.
![](https://s1.ax1x.com/2018/10/06/i8IIr8.png)
9. However, if the room has been booked by others at that period, it would pop you error message.
10. To enter the user center, click the **Hello, James** on the top-right coner, your history orders would be listed. This step is authorisation required, please login first, otherwise, you would be navigated to a permission denied page.
![](https://s1.ax1x.com/2018/10/06/i8IOGn.png)
 11. Customer can cancel their own orders in **2 days advance** by click the **cancel order** button. If it's successfully cancelled, customer would be given a success message. If it's failed, which usually caused by trying to cancel the order which the check-in-time is **within 2 days**, an error message will be poped.
11. If an order has been successfully cancelled, when you check it in the user center, its status should be **cancel**.
![](https://s1.ax1x.com/2018/10/06/i8oAR1.png)

### Part 3 (Feature B)
> - Staff
	- Receptionist
		`Receptionist` can help customer to place the order. `Receptionist` can also modify the information of **unfinished** history order.
	- Manager
		`Manager` can also help customer to place the order. `Manager` can modify the information of **all** history order, including finished orders. `Manager` is able to manage the property information, including the information about **buildings** and **rooms**.
#### Receptionist manage orders
1. From the [Index Page](https://www.yaleyoo.com/Sakura/), click the **Staff** button to access the staff management page.
![](https://s1.ax1x.com/2018/10/06/i8ohFJ.png)
2. Then click **Receptionist** to login as a receptionist. Then click the **Manage Orders** link, a dropdown list would shows up. Click the **Place New Order** link to place a new order. The user will be navigated to a choose customer page. (**NOTE that this step is authorisation required**).
![](https://s1.ax1x.com/2018/10/06/i8Tyhd.png)
3. Receptionist should ask whether the customer already has an account, if ther are not, using **New Customer** tablet to create an account for them. Click the **Create** button to insert the new customer or click the **Cancel** button to return to the previous page.
4. Check the customer details again, if they are all correct, click **Next** button to confirm or click the **Cancel** button to cancel the create action.
![](https://s1.ax1x.com/2018/10/06/i8T2ct.png)
5. If the customer has been successfully created, user would be navigated to the page that listed all of the rooms. Then input the check-in-time and check-out-time to search the available rooms. That step is similar with how customer place the order by themselves. Except the the current customer id would shown on the left-top coner.
![](https://s1.ax1x.com/2018/10/06/i8TRjP.png)
6. Then similar with the customer place order processes, select a room, book it, confirm the order's details, then place the order.
7. Receptionist can also check the details of history orders. In **Staff Management Page**, click the **Manage Orders** link, then select **Check Current Orders**, a page for searching the orders will shows up.
![](https://s1.ax1x.com/2018/10/06/i8ohFJ.png)
8.  Then input the order ID to search a specific order. A example order ID is **1810052334281**.
![](https://s1.ax1x.com/2018/10/06/i87ig1.png)
9. Click the **search** button, if the order with the specific orderId has been found, its detail will be listed.
![](https://s1.ax1x.com/2018/10/06/i87d8s.png)
Do the neccessary modification. Then click **Edit Order** button to perform the modification. **NOTE that the Receptionist cannot modify the order which the status is finished.** When the receptionist trying to search the detail about finished order, the request will be denied.

10. In case the customer is already the existing customer of the Sakura Hotel, select the **Existing Customer** when choosing customer. 
![](https://s1.ax1x.com/2018/10/06/i8O0Bt.png)
11. Inputting customer's email address and press **Search** button, if there is any existing customer in the database, that customer's details would be shown.
![](https://s1.ax1x.com/2018/10/06/i8OrAf.png)
12. If the information is correct, click **Next** button. Then doing the remaining steps of placing order, which is exactly the same as the case that customer is new.

#### Manager manage the properties
1. From the [Index Page](https://www.yaleyoo.com/Sakura/), click the **Staff** on the top-right corner to access the staff management page.
![](https://s1.ax1x.com/2018/10/06/i8ohFJ.png)
2. Click the **Manager** button on the top-right side to login as a manager. Then click the **Manage Properties** button, a list of buildings would shows up.
![](https://s1.ax1x.com/2018/10/06/i8o4Y9.png)
3. Click **Delete** button to delete a building. **NOTE: please don't delete the first 2 buildings, otherwise the related rooms would be deleted as well.**
4. Click **Add a New Building** button at the button to insert a new building. User would be navigated to a page to input the new building information. Then input the details of the new building, click **confirm** button to make the change. Or click the **cancel** button to return to the last history page.
![](https://s1.ax1x.com/2018/10/06/i8o5WR.png)
5. By clicking the **confirm** button, the new building would be created. A success or error message will be shown. Then check the properties again (by clicking the **manage properties** link on the navibar), the information about new building will be listed.
![](https://s1.ax1x.com/2018/10/06/i8oHOK.png)
6. To edit the building's details, click the **edit** button, the details of the selected building would be automatically filled in the form. **Note that** the building Id is uneditable. When finish the modification, click **confirm** button to make the change, or click the **cancel** button to return to the previous page.
![](https://s1.ax1x.com/2018/10/06/i8T96P.png)
7. Then user would be redirected to the Manage Properties page, the details of the building has been changed.
8. Click the **check rooms** button to view the rooms in that building.  
![](https://s1.ax1x.com/2018/10/06/i8TtpR.png)
Doing the modification on room list is similar with modifying the buildings.

#### Manager place the order
The process of how manager place the order is pretty the same with Receptionist place the order except the manager can also modify the finished orders.

