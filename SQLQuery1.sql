CREATE TABLE Department (
    DID INT IDENTITY(1,1) PRIMARY KEY Not Null,
    DName VARCHAR(50)
	);

	CREATE TABLE Employee (
    ID INT IDENTITY(1,1) PRIMARY KEY Not Null,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Phone VARCHAR(20) unique,
    DID INT Foreign key references Department (DID),
	Salary numeric(7,2) 
	);

	CREATE TABLE Admin (
    ID INT foreign KEY references Employee (ID),
	UserName VARCHAR(50) PRIMARY KEY ,
	Password VARCHAR(20) Not Null
    );

	CREATE TABLE Supplies (
    Type varchar(50) PRIMARY KEY,
	);

	CREATE TABLE OrderedSupplies (
	Ausername varchar(50) foreign key references Admin (UserName),
	Price NUMERIC(7,2),
	OrderDate DATE,
	Stype VARCHAR(50) foreign key references Supplies (Type)
	);

	CREATE TABLE Client (
    ClientID INT IDENTITY(1,1) PRIMARY KEY ,
    Nationality VARCHAR(50),
	Phone VARCHAR(50) Not Null,
	Name VARCHAR(50),
	Gender BIT
	);

	CREATE TABLE Bill (
    Bill_ID INT IDENTITY(1,1) PRIMARY KEY Not Null,
    Type VARCHAR(50),
	Total_payment NUMERIC(7,2),
	ClientID int foreign key references Client (ClientID)
	);
	
	CREATE TABLE Companion (
    ClientID int foreign key references Client (ClientID),
    Nationality VARCHAR(50),
	Phone VARCHAR(50) Not Null,
	Name VARCHAR(50),
	Gender BIT
	);
	
	CREATE TABLE Room (
    Class VARCHAR(50),
	Beds_No int,
	Price_per_day numeric(7,2),
	Status BIT,
	Room_Number INT PRIMARY KEY
	);

	CREATE TABLE Check_In_Out(
	BookingID INT IDENTITY(1,1) PRIMARY KEY Not Null,
	clientID int foreign key references Client (clientID),
	Room_N int foreign key references Room (Room_Number),
	StartDate DATE,
	EndDate DATE
	);

	CREATE TABLE Service (
    SName VARCHAR(50),
    ServiceType VARCHAR(50),
    price NUMERIC(5,2),
    CONSTRAINT PK_Service PRIMARY KEY (ServiceType, SName)
);

CREATE TABLE askFor (
    AskForID INT IDENTITY(1,1) PRIMARY KEY,
	ClientID INT FOREIGN KEY REFERENCES Client (ClientID),
    serviceType VARCHAR(50),
    SName VARCHAR(50),
    ServiceDate DATE,
    ServiceTime TIME,
    CONSTRAINT FK_askFor_Service FOREIGN KEY (serviceType, SName) REFERENCES Service (ServiceType, SName)  -- Foreign key
);

INSERT INTO Department (DName) VALUES 
('Housekeeping'),
('Front Desk'),
('Maintenance'),
('Food and Beverage');


INSERT INTO Employee (FirstName, LastName, Phone, DID, Salary) VALUES
('Sarah', 'Johnson', '1234567890', 2, 40000.00),
('Michael', 'Smith', '9876543210', 1, 45000.00),
('Emily', 'Davis', '5555555555', 3, 42000.00),
('David', 'Wilson', '6666666666', 4, 48000.00);

INSERT INTO Admin (ID, UserName, Password) VALUES
(1, 'admin1', 'password1'),
(2, 'admin2', 'password2'),
(3, 'admin3', 'password3'),
(4, 'admin4', 'password4');

INSERT INTO Supplies (Type) VALUES
('Cleaning Materials'),
('Kitchen Supplies'),
('Office Supplies'),
('Maintenance Tools');


INSERT INTO OrderedSupplies (Ausername, Price, OrderDate, Stype) VALUES
('admin1', 150.00, '2024-05-01', 'Cleaning Materials'),
('admin2', 200.00, '2024-05-02', 'Kitchen Supplies'),
('admin3', 100.00, '2024-05-03', 'Office Supplies'),
('admin4', 120.00, '2024-05-04', 'Maintenance Tools');

INSERT INTO Client (Nationality, Phone, Name, Gender) VALUES
('American', '1111111111', 'Alice', 0),
('British', '2222222222', 'Bob', 1),
('French', '3333333333', 'Claire', 0),
('German', '4444444444', 'David', 1);

INSERT INTO Bill (Type, Total_payment, ClientID) VALUES
('Room Charges', 250.00, 1),
('Food and Beverage', 75.00, 2),
('Room Service', 100.00, 3),
('Miscellaneous', 200.00, 4);

INSERT INTO Companion (ClientID, Nationality, Phone, Name, Gender) VALUES
(1, 'American', '5555555555', 'Eve', 0),
(2, 'British', '6666666666', 'Frank', 1),
(3, 'French', '7777777777', 'Grace', 0),
(4, 'German', '8888888888', 'Henry', 1);

INSERT INTO Room (Class, Beds_No, Price_per_day, Status, Room_Number) VALUES
('Standard', 2, 100.00, 1, 101),
('Deluxe', 3, 150.00, 0, 102),
('Suite', 4, 200.00, 1, 103),
('Penthouse', 5, 300.00, 0, 104);

INSERT INTO Check_In_Out (clientID, Room_N, StartDate, EndDate) VALUES
(1, 101, '2024-05-01', '2024-05-05'),
(2, 102, '2024-05-02', '2024-05-06'),
(3, 103, '2024-05-03', '2024-05-07'),
(4, 104, '2024-05-04', '2024-05-08');



INSERT INTO Service (SName, ServiceType, price) VALUES
('Breakfast', 'Food', 10.00),
('Lunch', 'Food', 15.00),
('Dinner', 'Food', 20.00),
('Room Cleaning', 'Cleaning', 30.00),
('Laundry', 'Cleaning', 25.00),
('Housekeeping', 'Cleaning', 40.00),
('Plumbing', 'Maintenance', 50.00),
('Electrical Maintenance', 'Maintenance', 60.00),
('HVAC Service', 'Maintenance', 70.00);


INSERT INTO askFor (ClientID, serviceType, SName, ServiceDate, ServiceTime) VALUES
(1, 'Food', 'Breakfast', '2024-05-02', '08:00:00'), 
(2, 'Food', 'Lunch', '2024-05-03', '12:00:00'),       
(3, 'Cleaning', 'Room Cleaning', '2024-05-04', '10:00:00'),  
(4, 'Maintenance', 'Plumbing', '2024-05-05', '14:00:00');    







