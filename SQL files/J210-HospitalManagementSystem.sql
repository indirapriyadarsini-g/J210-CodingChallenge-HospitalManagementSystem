create database j210hospitalmanagementsystem;
use j210hospitalmanagementsystem;

-- drop database j210hospitalmanagementsystem;-- 
create table patient (
    patient_id int primary key,
    first_name varchar(255),
    last_name varchar(255),
    date_of_birth date,
    gender varchar(10),
    contact_number varchar(15),
    address varchar(255)
);

create table doctor (
    doctor_id int primary key,
    first_name varchar(255),
    last_name varchar(255),
    specialization varchar(255),
    contact_number varchar(15)
);

create table appointment (
    appointment_id int primary key,
    patient_id int,
    doctor_id int,
    appointment_date date,
    description text,
    foreign key (patient_id) references patient(patient_id),
    foreign key (doctor_id) references doctor(doctor_id)
);


insert into patient (patient_id, first_name, last_name, date_of_birth, gender, contact_number, address) values
(1, 'p1', 'l1', '1990-05-15', 'Male', '1234567890', 'add1'),
(2, 'p2', 'l2', '1985-08-20', 'Female', '9876543210', 'add2'),
(3, 'p3', 'l3', '1978-12-10', 'Male', '5551112222', 'add3'),
(4, 'p4', 'l4', '1995-04-25', 'Female', '4443332222', 'add4'),
(5, 'p5', 'l5', '1980-06-30', 'Male', '7778889999', 'add5'),
(6, 'p6', 'l6', '1992-09-05', 'Female', '3332221111', 'add6'),
(7, 'p7', 'l7', '1987-02-18', 'Male', '9998887777', 'add7'),
(8, 'p8', 'l8', '1975-07-12', 'Female', '6665554444', 'add8'),
(9, 'p9', 'l9', '1983-03-22', 'Male', '2223334444', 'add9'),
(10, 'p10', 'l10', '1998-11-28', 'Female', '1112223333', 'add10');

insert into doctor (doctor_id, first_name, last_name, specialization, contact_number) values
(1, 'd1', 'l1', 'Cardiology', '1234567890'),
(2, 'd2', 'l2', 'Neurology', '9876543210'),
(3, 'd3', 'l3', 'Orthopedics', '5551112222'),
(4, 'd4', 'l4', 'Pediatrics', '4443332222'),
(5, 'd5', 'l5', 'Oncology', '7778889999'),
(6, 'd6', 'l6', 'Dermatology', '3332221111'),
(7, 'd7', 'l7', 'Psychiatry', '9998887777'),
(8, 'd8', 'l8', 'Gynecology', '6665554444'),
(9, 'd9', 'l9', 'Urology', '2223334444'),
(10, 'd10', 'l10', 'ENT', '1112223333');
