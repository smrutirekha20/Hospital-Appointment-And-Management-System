package com.hams.hamsvc.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "specializations")
public class Specialization {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "specialization_id")
        private Integer specializationId;

        @Column(name = "specialization_name")
        private String specializationName;

        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;

        @OneToMany(mappedBy = "specialization")
        private List<Doctor> doctors;

        public void setSpecializationId(Integer specializationId){
            this.specializationId=specializationId;
        }
        public Integer getSpecializationId(){
            return specializationId;
        }
        public void setSpecializationName(String specializationName){
            this.specializationName=specializationName;
        }
        public String getSpecializationName(){
            return specializationName;
        }
        public void setDepartment(Department department){
            this.department=department;
        }
        public Department getDepartment(){
            return department;
        }
       public void setDoctors(List<Doctor> doctors){
        this.doctors=doctors;
       }
       public List<Doctor> getDoctors(){
        return doctors;
      }
}
