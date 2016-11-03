//
//  ProgramaPageTableViewController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/19/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit

class ProgramaPageTableViewController: UITableViewController {

    var type:String = ""
    
    let sections:[String] = ["Jeudi / 11.08", "Vendredi / 12.08", "Samedi / 13.08", "Lundi / 15.08", "Mardi / 16.08", "Jeudi / 18.08", "Vendredi / 19.08", "Samedi / 20.09"]
    
    let sectionsOff:[String] = ["Lundi / 15.08", "Mardi / 16.08", "Mercredi / 17.08", "Jeudi / 18.08", "Vendredi / 19.08", "Samedi / 20.09"]
    
    
    // Boogie Woogie
    let boggieHoursT:[Programa] = [Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Cours Découverte Gratuit\r\nNicolas & Irene"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Boogie Competition ( en couple )\nThobjorn & Flora"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Boogie Intermediaire\nThobjorn & Flora"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Boogie Avancé\nWilliam & Maeva"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 1", t: "Boogie Intermediaire\nThobjorn & Flora"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 2", t: "Boogie Avancé\nWilliam & Maeva"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 1", t: "Boogie Débutant\nSondre & Tanya"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 2", t: "Boogie Novices\nJeff & Joelle"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 1", t: "Boogie Débutant\nSondre & Tanya"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 2", t: "Boogie Novices\nJeff & Joelle")]
    
    let boggieHoursF:[Programa] = [Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Cours Découverte Gratuit\nJeff & Joelle"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Boogie Competition ( en couple )\nSondre & Tanya"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Boogie Intermediaire\nSondre & Tanya"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Boogie Avancé\nThobjorn & Flora"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 1", t: "Boogie Intermediaire\nSondre & Tanya"),
                                   Programa(h: "13:20-14:20", hl: "Chapiteau 2", t: "Boogie Avancé\nThobjorn & Flora"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 1", t: "Boogie Débutant\nWilliam & Maeva"),
                                   Programa(h: "14:30-15:30", hl: "Chapiteau 2", t: "Boogie Novices\nJeff & Joelle"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 1", t: "Boogie Débutant\nWilliam & Maeva"),
                                   Programa(h: "15:40-16:40", hl: "Chapiteau 2", t: "Boogie Novices\nNicolas & Irene")]
    
    let boggieHoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Cours Découverte Gratuit\nMartin & Cathy"),
                                    Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Boogie Competition ( en couple )\nPontus & Isabella"),
                                    Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Boogie Intermediaire\nSondre & Tanya"),
                                    Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Boogie Avancé\nPontus & Isabella"),
                                    Programa(h: "13:20-14:20", hl: "Chapiteau 1", t: "Boogie Intermediaire\nThobjorn & Flora"),
                                    Programa(h: "13:20-14:20", hl: "Chapiteau 2", t: "Boogie Avancé\nSondre & Tanya"),
                                    Programa(h: "14:30-15:30", hl: "Chapiteau 1", t: "Boogie Débutant\nThobjorn & Flora"),
                                    Programa(h: "14:30-15:30", hl: "Chapiteau 2", t: "Boogie Novices\nMartin & Cathy"),
                                    Programa(h: "15:40-16:40", hl: "Chapiteau 1", t: "Boogie Débutant\nSondre & Tanya"),
                                    Programa(h: "15:40-16:40", hl: "Chapiteau 2", t: "Boogie Novices\nMartin & Cathy")]
    
    // Boogie Woogie OFF
    let boggieOffHoursT:[Programa] = [Programa(h: "11:00-16:40", hl: "", t: "Cours de Danses"),
                                   Programa(h: "17:00", hl: "De la place de l’Eglise au chapiteau", t: "LES ROLLING DOMINOS"),
                                   Programa(h: "18:00", hl: "Inauguration chapiteau", t: "LES ROLLING DOMINOS"),
                                   Programa(h: "18:00", hl: "BAL SWING BOOGIE", t: "DJ LO, DJ Patrick"),
                                   Programa(h: "19:00", hl: "Place de l’Eglise", t: "LES ROLLING DOMINOS")]
    
    let boggieOffHoursF:[Programa] = [Programa(h: "11:00-16:40", hl: "", t: "Cours de Danses"),
                                   Programa(h: "16:30", hl: "Place de l’église au restaurant de la Gare", t: "ALFRED AND HIS GANG"),
                                   Programa(h: "16:30", hl: "Place de l’église au restaurant de la Gare", t: "Exposition photographique de Pierrick Delobelle"),
                                   Programa(h: "18:00", hl: "Place Sabatier", t: "LES ROLLING DOMINOS"),
                                   Programa(h: "18:00", hl: "BAL SWING BOOGIE", t: "DJ LO, DJ Patrick"),
                                   Programa(h: "19:00", hl: "Place de l’Eglise", t: "ALFRED AND HIS GANG"),
                                   Programa(h: "19:00", hl: "Espace salle polyvalente", t: "LES ROLLING DOMINOS")]
    
    let boggieOffHoursSt:[Programa] = [Programa(h: "11:00-16:40", hl: "", t: "Cours de Danses"),
                                    Programa(h: "16:00", hl: "Place de l’Eglise", t: "BOOGIE PHIL AND THE WISE GUYS"),
                                    Programa(h: "17:00", hl: "RDV Place de l’église pour une balade musicale à travers le village", t: "LES ROLLING DOMINOS"),
                                    Programa(h: "17:30", hl: "Place de l’Eglise", t: "Le Rouget – ALFRED AND HIS GANG"),
                                    Programa(h: "18:00", hl: "", t: "BATTLE BOOGIE WOOGIE & Bal Swing"),
                                    Programa(h: "18:15", hl: "Place de l’église", t: "BOOGIE PHIL AND THE WISE GUYS"),
                                    Programa(h: "19:15", hl: "", t: "LES ROLLING DOMINOS déambuleront aux terrasses des bars"),
                                    Programa(h: "19:30", hl: "Place de l’église", t: "ALFRED AND HIS GANG")]
    
    
    // Lindy hop
    let lindyHoursM:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nMax & Audrey"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                  Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nMax & Audrey"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMiguel & Carla"),
                                  Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                  Programa(h: "14:00-15:10", hl: "Salle Polyvalente", t: "Solo JAzz Inter\nNicolas Rodriguez"),
                                  Programa(h: "14:00-15:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "14:00-15:10", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nOliv"),
                                  Programa(h: "15:20-16:20", hl: "Salle Polyvalente", t: "Solo Jazz Avancé\nCarla"),
                                  Programa(h: "15:20-16:20", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "16:20-17:20", hl: "Chapiteau 1", t: "SoloJazz Avancé +\nTatiana"),
                                  ]
    
    let lindyHoursTu:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nJb & Tatiana"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nPontus & Isabella"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThomas & Maeva"),
                                   Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nJb & Tatiana"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nPontus & Isabella"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThomas & Maeva"),
                                   Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                   Programa(h: "14:00-15:10", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nMax & Audrey"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nJb & Tatiana"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 2", t: "Lindy Hop Inter\nThomas & Maeva"),
                                   Programa(h: "15:20-16:20", hl: "Salle Polyvalente", t: "Solo Jazz\nAvancé + Max"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 1", t: "Solo Jazz Avancé\nAndy"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 2", t: "Lindy Hop Inter\nThomas & Maeva"),
                                   Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nNicolas Rodriguez"),
                                   Programa(h: "16:20-17:20", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nAudrey")]
    
    let lindyHoursTh:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nJb & Tatiana"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nMax & Audrey"),
                                   Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                   Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nJb & Tatiana"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nMax & Audrey"),
                                   Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                   Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                   Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                   Programa(h: "14:00-15:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nPontus & Isabella"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé+\nMax & Audrey"),
                                   Programa(h: "14:00-15:10", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nNicolas Rodriguez"),
                                   Programa(h: "15:20-16:20", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nJb Mino"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 1", t: "Lindy Hop Avancé+\nThomas & Maeva"),
                                   Programa(h: "15:20-16:20", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nNicolas Rodriguez"),
                                   Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Avancé\nAndy"),
                                   Programa(h: "21:00-22:00", hl: "", t: "Cour de musicalité avec\nOliv Wan"),
                                   ]
    
    let lindyHoursF:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nJb & Tatiana"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMiguel & Carla"),
                                  Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Avancé +\nPontus & Isabella"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nJb & Tatiana"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMiguel & Carla"),
                                  Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                  Programa(h: "14:00-15:00", hl: "Salle Polyvalente", t: "Solo Jazz Avancé +\nAndy"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 1", t: "Solo Jazz Avancé\nOliv Wan"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 2", t: "Lindy Hop Inter\nMiguel & Carla"),
                                  Programa(h: "15:00-16:10", hl: "Salle Polyvalente", t: "Solo Jazz Avancé +\nAndy"),
                                  Programa(h: "15:00-16:10", hl: "Chapiteau 1", t: "Solo Jazz Avancé\nOliv Wan"),
                                  Programa(h: "15:00-16:10", hl: "Chapiteau 2", t: "Lindy Hop Inter\nMiguel & Carla"),
                                  Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nAndy"),
                                  Programa(h: "16:20-17:20", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nNicolas Rodriguez")]
    
    let lindyHoursS:[Programa] = [Programa(h: "11:00-12:00", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nPontus & Isabella"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "11:00-12:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nThobjorn & Flora"),
                                  Programa(h: "12:10-13:10", hl: "Salle Polyvalente", t: "Lindy Hop Inter\nPontus & Isabella"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé\nThomas & Maeva"),
                                  Programa(h: "12:10-13:10", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nMax & Audrey"),
                                  Programa(h: "13:10-14:00", hl: "Salle Polyvalente", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 1", t: "Break"),
                                  Programa(h: "13:10-14:00", hl: "Chapiteau 2", t: "Break"),
                                  Programa(h: "14:00-15:00", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nNicolas Rodriguez"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nJb & Tatiana"),
                                  Programa(h: "14:00-15:00", hl: "Chapiteau 2", t: "Lindy Hop Débutant\nPontus & Isabella"),
                                  Programa(h: "15:10-16:10", hl: "Salle Polyvalente", t: "Solo Jazz Inter\nMiguel"),
                                  Programa(h: "15:10-16:10", hl: "Chapiteau 1", t: "Lindy Hop Avancé +\nMax & Audrey"),
                                  Programa(h: "15:10-16:10", hl: "Chapiteau 2", t: "Solo Jazz Débutant\nOliv Wan"),
                                  Programa(h: "16:20-17:20", hl: "Salle Polyvalente", t: "Solo Jazz Avancé\nOliv Wan"),
                                  Programa(h: "16:20-17:20", hl: "Chapiteau 1", t: "Solo Jazz Avancé +\nJb Mino")]
    
    // Lindy hop Off
    let lindyOffHoursM:[Programa] = [Programa(h: "18:00", hl: "La salle Polyvalente", t: "Welcome Drink with Live music ( The Swing Shouters )"),
                                  Programa(h: "22:00", hl: "", t: "Party with The Swing Shouters at The Salle Polyvalente")
                                  ]
    
    let lindyOffHoursTu:[Programa] = [Programa(h: "18:00", hl: "The bar le Joker", t: "Drinks and Social Dancing with the Rhythm Gamblers"),
                                      Programa(h: "22:00", hl: "The Salle Polyvalente", t: "Party with The Rhythm Gamblers")]
    
    let lindyOffHoursW:[Programa] = [Programa(h: "10:00-12:00", hl: "", t: "Petanque Tournament near the River ( only 30 spots available )"),
                                      Programa(h: "14:00-16:00", hl: "", t: "Petanque Tournament near the River"),
                                      Programa(h: "17:00", hl: "", t: "Parade from the Castel to the Chapiteau. ( Live music )"),
                                      Programa(h: "18:00", hl: "", t: "Prelims Jack ‘N’Jill & Solo Jazz Competition at the Chapiteau"),
                                      Programa(h: "22:00", hl: "", t: "Party with The Rhythm Gamblers"),
                                      Programa(h: "00:30", hl: "", t: "Jack ‘N’Jill & Solo Jazz Finals"),
                                      Programa(h: "02:00-04:00", hl: "The Joker", t: "After Party")]
    
    let lindyOffHoursTh:[Programa] = [Programa(h: "18:00", hl: "", t: "Apéro Swing Aout sur le Parvis de la salle polyvalente"),
                                   Programa(h: "21:00-22:00", hl: "", t: "Musicality Class with Oliv Wan ( Open )"),
                                   Programa(h: "22:00", hl: "The Salle Polyvalente", t: "Party with Emilie Cole & The Rhythm Band")
                                   ]
    
    let lindyOffHoursF:[Programa] = [Programa(h: "18:00", hl: "The Joker", t: "Apero Swing with The Rhythm Gamblers"),
                                  Programa(h: "22:00", hl: "The Salle Polyvalente", t: "Party with Emilie Cole & The Rhythm Band"),
                                  Programa(h: "02:00-04:00", hl: "The Joker", t: "After Party")]
    
    let lindyOffHoursS:[Programa] = [Programa(h: "18:00", hl: "The Camping Municipal", t: "Drinks & Jam Session"),
                                  Programa(h: "22:00", hl: "The Salle Polyvalente", t: "Party with Emilie Cole & The Rhythm Band"),
                                  Programa(h: "02:00-04:00", hl: "The Joker", t: "After Party")]
    
    // Parties
    let partiesHoursTh1:[Programa] = [Programa(h: "22:30-23:00", hl: "", t: "DJ William"),
                                     Programa(h: "23:00-23:30", hl: "", t: "DJ Nicolas Rodriguez"),
                                     Programa(h: "22:30-00:30", hl: "", t: "DJ El Cerf"),
                                     Programa(h: "00:30-00:45", hl: "", t: "Presentation Boogie Woogie Teachers"),
                                     Programa(h: "00:45-01:30", hl: "", t: "DJ Battle ( 2 songs per DJ Willian / Jeff / Nicolas )"),
                                     Programa(h: "01:30-02:00", hl: "", t: "DJ El Cerf"),
                                     Programa(h: "02:00-03:00", hl: "", t: "DJ Battle ( 2 songs per DJ -William / Jeff / Nicolas- )")]
    
    let partiesHoursF1:[Programa] = [Programa(h: "22:30-23:00", hl: "", t: "DJ William"),
                                     Programa(h: "23:00-23:30", hl: "", t: "Live Music with The Swing Shouters"),
                                     Programa(h: "22:30-00:30", hl: "", t: "DJ El Cerf"),
                                     Programa(h: "00:30-00:45", hl: "", t: "Live music with The Swing Shouters"),
                                     Programa(h: "00:45-01:30", hl: "", t: "DJ Nicolas Rodriguez"),
                                     Programa(h: "01:30-02:00", hl: "", t: "Live music with The Swing Shouters"),
                                     Programa(h: "02:00-03:00", hl: "", t: "DJ El Cerf")]
    
    let partiesHoursS1:[Programa] = [Programa(h: "22:30-23:00", hl: "", t: "DJ William"),
                                     Programa(h: "23:00-23:30", hl: "", t: "Live Music with The Swing Shouters"),
                                     Programa(h: "22:30-00:30", hl: "", t: "DJ Nicolas Rodriguez"),
                                     Programa(h: "00:30-00:45", hl: "", t: "Live music with The Swing Shouters"),
                                     Programa(h: "00:45-01:30", hl: "", t: "DJ El Cerf"),
                                     Programa(h: "01:30-02:00", hl: "", t: "Live music with The Swing Shouters"),
                                     Programa(h: "02:00-03:00", hl: "", t: "DJ Battle ( 2 songs per DJ -William / Jeff / Nicolas- )")]
    
    let partiesHoursM:[Programa] = [Programa(h: "22:00-22:30", hl: "", t: "DJ Nicolas Rodriguez"),
                                    Programa(h: "22:30-23:15", hl: "", t: "Live Music with The Swing Shouters"),
                                    Programa(h: "23:15-23:45", hl: "", t: "DJ Nicolas Rodriguez"),
                                    Programa(h: "23:45-00:30", hl: "", t: "Live music with The Swing Shouters"),
                                    Programa(h: "00:30-01:00", hl: "", t: "DJ William"),
                                    Programa(h: "01:00-01:45", hl: "", t: "Live music with The Swing Shouters"),
                                    Programa(h: "01:45-02:30", hl: "", t: "DJ Nicolas Rodriguez")]
    
    let partiesHoursTu:[Programa] = [Programa(h: "22:00-22:30", hl: "", t: "DJ Andy"),
                                     Programa(h: "22:30-23:15", hl: "", t: "Live with The Rhythm Gamblers tribute to Count Basie"),
                                     Programa(h: "23:15-23:45", hl: "", t: "DJ Nicolas Rodriguez"),
                                     Programa(h: "23:45-00:30", hl: "", t: "Live with The Rhythm Gamblers tribute to Count Basie"),
                                     Programa(h: "00:30-01:00", hl: "", t: "DJ William"),
                                     Programa(h: "01:00-01:45", hl: "", t: "Live with The Rhythm Gamblers tribute to Count Basie"),
                                     Programa(h: "01:45-02:30", hl: "", t: "DJ El Cerf"),
                                     Programa(h: "02:30-03:30", hl: "", t: "DJ Nicolas Rodriguez")]
    
    let partiesHoursW:[Programa] = [Programa(h: "22:00-22:30", hl: "", t: "DJ Andy Spitz"),
                                    Programa(h: "22:30-23:15", hl: "", t: "Live with The Rhythm Gamblers"),
                                    Programa(h: "23:15-23:45", hl: "", t: "Teachers Cabaret ( DJ Nicolas Rodriguez )"),
                                    Programa(h: "23:45-00:30", hl: "", t: "Live with The Rhythm Gamblers"),
                                    Programa(h: "00:30-01:00", hl: "", t: "Final Jack’N’Jill & Solo Jazz Competition"),
                                    Programa(h: "01:00-01:45", hl: "", t: "Live with The Rhythm Gamblers"),
                                    Programa(h: "01:45-02:30", hl: "", t: "DJWilliam&NicolasRodriguez(RhythmNBlues)"),
                                    Programa(h: "02:30-04:00", hl: "", t: "AFTER PARTY au Bar Le Joker")]
    
    let partiesHoursTh:[Programa] = [Programa(h: "21:00-22:00", hl: "", t: "Cour Musicalité avec Oliv Wan"),
                                     Programa(h: "22:00-22:30", hl: "", t: "Début de soirée DJ Andy"),
                                     Programa(h: "22:30-23:15", hl: "", t: "Live with The Rhythm Gamblers"),
                                     Programa(h: "23:15-23:45", hl: "", t: "DJ Nicolas Rodriguez"),
                                     Programa(h: "23:45-00:30", hl: "", t: "Live with The Rhythm Gamblers"),
                                     Programa(h: "00:30-01:00", hl: "", t: "DJ William"),
                                     Programa(h: "01:00-01:45", hl: "", t: "Live with The Rhythm Gamblers"),
                                     Programa(h: "01:45-02:30", hl: "", t: "DJ El Cerf"),
                                     Programa(h: "02:30-03:30", hl: "", t: "DJ Damien Verron « New Orleans »")]
    
    let partiesHoursF:[Programa] = [Programa(h: "22:00-22:30", hl: "", t: "Début de soirée DJ William"),
                                    Programa(h: "22:30-23:15", hl: "", t: "Live with Emilie Cole & The Rhythm Gamblers"),
                                    Programa(h: "23:15-23:45", hl: "", t: "DJ Nicolas Rodriguez"),
                                    Programa(h: "23:45-00:30", hl: "", t: "Live with Emilie Cole & The Rhythm Gamblers"),
                                    Programa(h: "00:30-01:00", hl: "", t: "DJ Andy Spitz"),
                                    Programa(h: "01:00-01:45", hl: "", t: "Live with Emilie Cole & The Rhythm Gamblers"),
                                    Programa(h: "01:45-02:30", hl: "", t: "DJ Nicolas Rodriguez"),
                                    Programa(h: "02:30-03:30", hl: "", t: "DJ Damien Verron « New Orleans »"),
                                    Programa(h: "02:00-04:00", hl: "", t: "AFTER PARTY au Bar Le Joker")]
    
    let partiesHoursS:[Programa] = [Programa(h: "22:00-22:30", hl: "", t: "Début de soirée DJ William"),
                                    Programa(h: "22:30-23:15", hl: "", t: "Live with Emilie Cole & The Rhythm Gamblers"),
                                    Programa(h: "23:15-23:45", hl: "", t: "DJ Nicolas Rodriguez"),
                                    Programa(h: "23:45-00:30", hl: "", t: "Live with Emilie Cole & The Rhythm Gamblers"),
                                    Programa(h: "00:30-01:00", hl: "", t: "DJ Andy Spitz"),
                                    Programa(h: "01:00-01:45", hl: "", t: "Live with Emilie Cole & The Rhythm Gamblers"),
                                    Programa(h: "01:45-02:30", hl: "", t: "DJ El Cerf"),
                                    Programa(h: "02:30-03:30", hl: "", t: "DJ Nicolas Rodriguez & William"),
                                    Programa(h: "02:00-04:00", hl: "", t: "AFTER PARTY au Bar Le Joker")]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.tableFooterView = UIView()
        
        switch type {
        case "lindy":
            title = "Lindy"
            break
        case "boggie":
            title = "Boogie Woogie"
            break
        case "boogieOff":
            title = "Boogie Woogie / OFF"
            break
        case "lindyOff":
            title = "LINDYHOP/SOLOJAZZ \\ OFF"
            break
        case "boogieParty":
            title = "PARTY SCHEDULE ( BOOGIE WOOGIE )"
            break
        case "lindyParty":
            title = "PARTY SCHEDULE ( LINDY WEEK )"
            break
            
        default:
            break
        }
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        if (type == "boggie" || type == "boogieOff" || type == "boogieParty") {
            return 3
        }
        if (type == "lindyOff" || type == "lindyParty") {
            return 6
        }
        
        return 5;
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        switch type {
        case "boggie":
            if (section == 0) {return boggieHoursT.count}
            if (section == 1) {return boggieHoursF.count}
            if (section == 2) {return boggieHoursSt.count}
            break
        case "boogieOff":
            if (section == 0) {return boggieOffHoursT.count}
            if (section == 1) {return boggieOffHoursF.count}
            if (section == 2) {return boggieOffHoursSt.count}
            break
        case "lindy":
            if (section == 0) {return lindyHoursM.count}
            if (section == 1) {return lindyHoursTu.count}
            if (section == 2) {return lindyHoursTh.count}
            if (section == 3) {return lindyHoursF.count}
            if (section == 4) {return lindyHoursS.count}
            break
        case "lindyOff":
            if (section == 0) {return lindyOffHoursM.count}
            if (section == 1) {return lindyOffHoursTu.count}
            if (section == 2) {return lindyOffHoursW.count}
            if (section == 3) {return lindyOffHoursTh.count}
            if (section == 4) {return lindyOffHoursF.count}
            if (section == 5) {return lindyOffHoursS.count}
            break
        case "boogieParty":
            if (section == 0) {return partiesHoursTh1.count}
            if (section == 1) {return partiesHoursF1.count}
            if (section == 2) {return partiesHoursS1.count}
            break
        case "lindyParty":
            if (section == 0) {return partiesHoursM.count}
            if (section == 1) {return partiesHoursTu.count}
            if (section == 2) {return partiesHoursW.count}
            if (section == 3) {return partiesHoursTh.count}
            if (section == 4) {return partiesHoursF.count}
            if (section == 5) {return partiesHoursS.count}
            break
        default:
            break
        }
        
        return 0
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell:ProgaramaPageTableViewCell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath) as! ProgaramaPageTableViewCell

        var pg:Programa = Programa()
        switch type {
        case "boggie":
            if ((indexPath as NSIndexPath).section == 0) {pg = boggieHoursT[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 1) {pg = boggieHoursF[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 2) {pg = boggieHoursSt[(indexPath as NSIndexPath).row]}
            break
        case "boogieOff":
            if ((indexPath as NSIndexPath).section == 0) {pg = boggieOffHoursT[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 1) {pg = boggieOffHoursF[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 2) {pg = boggieOffHoursSt[(indexPath as NSIndexPath).row]}
            break
        case "lindy":
            if ((indexPath as NSIndexPath).section == 0) {pg = lindyHoursM[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 1) {pg = lindyHoursTu[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 2) {pg = lindyHoursTh[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 3) {pg = lindyHoursF[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 4) {pg = lindyHoursS[(indexPath as NSIndexPath).row]}
            break
        case "lindyOff":
            if ((indexPath as NSIndexPath).section == 0) {pg = lindyOffHoursM[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 1) {pg = lindyOffHoursTu[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 2) {pg = lindyOffHoursW[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 3) {pg = lindyOffHoursTh[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 4) {pg = lindyOffHoursF[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 5) {pg = lindyOffHoursS[(indexPath as NSIndexPath).row]}
            break
        case "boogieParty":
            if ((indexPath as NSIndexPath).section == 0) {pg = partiesHoursTh1[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 1) {pg = partiesHoursF1[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 2) {pg = partiesHoursS1[(indexPath as NSIndexPath).row]}
            break
        case "lindyParty":
            if ((indexPath as NSIndexPath).section == 0) {pg = partiesHoursM[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 1) {pg = partiesHoursTu[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 2) {pg = partiesHoursW[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 3) {pg = partiesHoursTh[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 4) {pg = partiesHoursF[(indexPath as NSIndexPath).row]}
            if ((indexPath as NSIndexPath).section == 5) {pg = partiesHoursS[(indexPath as NSIndexPath).row]}
            break
            
        default:
            break
        }

        cell.titleLabel?.text = pg.title
        cell.hourLabel?.text = pg.hour
        cell.hallLabel?.text = pg.hall
        cell.hallLabel?.backgroundColor = UIColor.white
        if (pg.hall == "Salle Polyvalente") {
            cell.hallLabel?.backgroundColor = UIColor(red: 102.0/255.0, green: 1, blue: 0, alpha: 1.0)
        }
        if (pg.hall == "Chapiteau 1") {
            cell.hallLabel?.backgroundColor = UIColor(red: 1, green: 0.75, blue: 0, alpha: 1.0)
        }
        if (pg.hall == "Chapiteau 2") {
            cell.hallLabel?.backgroundColor = UIColor(red: 0.57, green: 0.82, blue: 0.31, alpha: 1.0)
        }
        
        
        return cell
    }
 

    override func tableView(_ tableView: UITableView,
                            heightForHeaderInSection section: Int) -> CGFloat{
        return 30
    }
    
    override func tableView(_ tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int)
    {
        let header = view as! UITableViewHeaderFooterView
        header.textLabel?.textColor = UIColor.lightGray
        if (type == "boggie" || type == "boogieOff" || type == "boogieParty") {
            header.textLabel?.text = sections[section]
        }
        if (type == "lindyOff" || type == "lindyParty") {
            header.textLabel?.text = sectionsOff[section]
        }
        if (type == "lindy") {
            header.textLabel?.text = sections[section+3]
        }
    }
    

    
    /*
    // Override to support conditional editing of the table view.
    override func tableView(tableView: UITableView, canEditRowAtIndexPath indexPath: NSIndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(tableView: UITableView, commitEditingStyle editingStyle: UITableViewCellEditingStyle, forRowAtIndexPath indexPath: NSIndexPath) {
        if editingStyle == .Delete {
            // Delete the row from the data source
            tableView.deleteRowsAtIndexPaths([indexPath], withRowAnimation: .Fade)
        } else if editingStyle == .Insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(tableView: UITableView, moveRowAtIndexPath fromIndexPath: NSIndexPath, toIndexPath: NSIndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(tableView: UITableView, canMoveRowAtIndexPath indexPath: NSIndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
