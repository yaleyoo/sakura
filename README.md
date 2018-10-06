# Sakura Hotel Booking System 
This system is developed for a start-up hotel company named Sakura Hotel to support their daily operation and enable customer to book online. Sakura Hotel is a hot-spring hotel and currently owns two buildings, and is considering to extend its business. 

## Live Demo
[Sakura Hotel Booking System](https://www.yaleyoo.com/Sakura/)

## Roles
- Customer
	`Customer` can search for the available rooms based on his/her **check-in time** and **check-out time** and book the available room. After the order has been placed, `customer` can check his order in **user center**. In user center, `customer` can also cancel his order in **at least 2 days advance**.
- Staff
	- Receptionist
		`Receptionist` can help customer to place the order. `Receptionist` can also modify the information of **unfinished** history order.
	- Manager
		`Manager` can also help customer to place the order. `Manager` can modify the information of **all** history order, including finished orders. `Manager` is able to manage the property information, including the information about **buildings** and **rooms**.

## Order Status
The order has four possible status:
- booking 
Order has been placed and the related room has been booked during the **check-in time** to **check-out time**.
- cancel
Order has been cancelled, the related room has been released.
- active
Customer has checked in, but hasn't checked out yet.
- finished
Customer has checked out, the order is finished.

## Test Senario
### Part 2:
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

In this step, check-out-time should after the check-in-time, also check-in-time should be a future time. If those requirements are fail to achive, an error message would shows up.
![](https://s1.ax1x.com/2018/10/06/i8I5Kf.png)
8. Check the details of the orders. If they are correc, click **confirm** button, your order. If the order is successfully placed, a successfully booked message would shows up.
![](https://s1.ax1x.com/2018/10/06/i8IIr8.png)
9. However, if the room has been booked by others at that period, it would pop you error message.
10. To enter the user center, click the **Hello, James** on the top-right coner, your history orders would be listed. This step is authorisation required, please login first, otherwise, you would be navigated to a permission denied page.
![](https://s1.ax1x.com/2018/10/06/i8IOGn.png)
 11. Customer can cancel their own orders in **2 days advance** by click the **cancel order** button. If it's successfully cancelled, customer would be given a success message. If it's failed, which usually caused by trying to cancel the order which the check-in-time is **within 2 days**, an error message will be poped.
11. If an order has been successfully cancelled, when you check it in the user center, its status should be **cancel**.
![](https://s1.ax1x.com/2018/10/06/i8oAR1.png)

### Part 3
> - Staff
	- Receptionist
		`Receptionist` can help customer to place the order. `Receptionist` can also modify the information of **unfinished** history order.
	- Manager
		`Manager` can also help customer to place the order. `Manager` can modify the information of **all** history order, including finished orders. `Manager` is able to manage the property information, including the information about **buildings** and **rooms**.

