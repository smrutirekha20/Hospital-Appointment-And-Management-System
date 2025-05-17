package com.hams.hamsvc.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "experience_years")
    private double experienceYears;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Slot> slots;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDoctorId(int doctorId){
        this.doctorId=doctorId;
    }
    public int getDoctorId(){
        return doctorId;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setExperienceYears(double experienceYears){
        this.experienceYears=experienceYears;
    }
    public double getExperienceYears(){
        return experienceYears;
    }
    public void setDepartment(Department department){
        this.department=department;
    }
    public Department getDepartment(){
        return department;
    }
   public void setSpecialization(Specialization specialization){
        this.specialization=specialization;
   }
   public Specialization getSpecialization(){
        return specialization;
   }
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
 public void setAppointments(List<Appointment> appointments){
        this.appointments=appointments;
 }
 public List<Appointment> getAppointments(){
        return appointments;
 }
    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
