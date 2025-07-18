/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author farro
 */
    public class HorasOcupadasVetoPolicy implements TimeVetoPolicy {
        private final List<LocalTime> horasNoDisponibles;

        public HorasOcupadasVetoPolicy(List<LocalTime> horasNoDisponibles) {
            this.horasNoDisponibles = horasNoDisponibles;
        }

        @Override
        public boolean isTimeAllowed(LocalTime time) {
            LocalTime min = LocalTime.of(6, 0);
            LocalTime max = LocalTime.of(18, 0);
            return !time.isBefore(min) &&
                   !time.isAfter(max) &&
                   !horasNoDisponibles.contains(time);
        }
    }