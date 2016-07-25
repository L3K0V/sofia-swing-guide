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
    
    let sections:[String] = ["Thursday", "Friday", "Saturday", "Sunday"]
    
    
    // OTHERS
    let othersHoursT:[Programa] = [Programa(h: "12:00-23:00", hl: "", t: "Registration"),
                                   Programa(h: "21:00-22:00", hl: "", t: "Talk with Ryan"),
                                   Programa(h: "21:00-04:00", hl: "Hall Bulgaria", t: "Party")]
    
    let othersHoursF:[Programa] = [Programa(h: "21:00-04:00", hl: "Hall Slovenia", t: "Party"),
                                   Programa(h: "21:00-22:00", hl: "Hall Bulgaria", t: "Open JnJ Prelims"),
                                   Programa(h: "22:30-23:30", hl: "Hall Slovenia", t: "Speakeasiest SB 1 set"),
                                   Programa(h: "23:30-00:00", hl: "Hall Slovenia", t: "Cabaret night"),
                                   Programa(h: "00:00-00:15", hl: "Hall Slovenia", t: "Open JnJ Finals"),
                                   Programa(h: "00:15-01:15", hl: "Hall Slovenia", t: "Speakeas SB 2 set")]
    
    let othersHoursSt:[Programa] = [Programa(h: "21:00-04:00", hl: "Hall Slovenia", t: "Party"),
                                    Programa(h: "21:00-21:30", hl: "Hall Slovenia", t: "Advanced JnJ Prelims"),
                                    Programa(h: "21:30-22:00", hl: "Hall Slovenia", t: "Strictly Lindy Prelims"),
                                    Programa(h: "22:30-23:30", hl: "Hall Slovenia", t: "Heart of Dixei set 1"),
                                    Programa(h: "23:30-23:45", hl: "Hall Slovenia", t: "Advanced JnJ Finals"),
                                    Programa(h: "23:45-00:00", hl: "Hall Slovenia", t: "Strictly Lindy Finals"),
                                    Programa(h: "00:00-01:00", hl: "Hall Slovenia", t: "Heart of Dixei set 2")]
    
    let othersHoursSn:[Programa] = [Programa(h: "16:30-16:50", hl: "Hall Bulgaria", t: "Group photoPrograma"),
                                    Programa(h: "16:50-19:00", hl: "", t: "Walking Tour with life music"),
                                    Programa(h: "21:00-04:00", hl: "Hall Bulgaria", t: "Party"),
                                    Programa(h: "22:00-22:30", hl: "Hall Bulgaria", t: "Swingout dropaut"),
                                    Programa(h: "22:30-23:30", hl: "Hall Bulgaria", t: "Heart of Dixei")]
    
    // Tasters
    let tastersHoursT:[Programa] = [Programa(h: "17:00-18:00", hl: "Hall Bulgaria", t: "1 (INT)Taster Class with Šárka & Štěpán")]
    
    let tastersHoursF:[Programa] = [Programa(h: "10:30-11:30", hl: "Hall Czech Republic", t: "2 (INT_ADV)Taster Class with Hakan&Nazlı"),
                                    Programa(h: "16:50-17:50", hl: "Hall Bulgaria", t: "3 (INT)Taster Class with Marcell&Dora"),
                                    Programa(h: "16:50-17:50", hl: "Hall Czech Republic", t: "4 (ADV)Taster Class with Peter&Elze"),
                                    Programa(h: "16:50-17:50", hl: "Hall Slovenia", t: "5 (INT-ADV)Taster Class with Nastya"),
                                    Programa(h: "18:00-19:00", hl: "Hall Bulgaria", t: "6 (INT)Taster Class with Šárka & Štěpán"),
                                    Programa(h: "18:00-19:00", hl: "Hall Czech Republic", t: "7 (ADV)Taster Class with Avgoustinos & Vassia"),
                                    Programa(h: "18:00-19:00", hl: "Hall Slovenia", t: "8 (INT-ADV)Taster Class with Pavlina&Simon")]
    
    let tastersHoursSt:[Programa] = [Programa(h: "16:00-17:00", hl: "Hall Bulgaria", t: "9 (ADV)Taster Class with Marcell&Dora"),
                                     Programa(h: "16:00-17:00", hl: "Hall Czech Republic", t: "10 (INT-ADV)Taster Class with Peter&Elze"),
                                     Programa(h: "16:00-17:00", hl: "Hall Slovenia", t: "11 (INT)Taster Class with Avgoustinos & Vassia"),
                                     Programa(h: "17:10-18:10", hl: "Hall Bulgaria", t: "12 (ADV)Taster Class with Hakan&Nazlı"),
                                     Programa(h: "17:10-18:10", hl: "Hall Czech Republic", t: "13 (INT-ADV)Taster Class with Nastya"),
                                     Programa(h: "17:10-18:10", hl: "Hall Slovenia", t: "14 (INT)Taster Class with Pavlina&Simon")]
    
    // Intermidiate
    let intHoursF:[Programa] = [Programa(h: "12:00-13:00", hl: "Hall Slovenia", t: "Audition"),
                                Programa(h: "13:10-14:10", hl: "Hall Bulgaria", t: "Felipe & Alice"),
                                Programa(h: "14:20-15:20", hl: "Hall Greece", t: "Max & Audrey"),
                                Programa(h: "15:30-16:30", hl: "Hall Greece", t: "Max & Audrey")]
    
    let intHoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "Hall Slovenia", t: "Felipe & Alice"),
                                 Programa(h: "12:10-13:10", hl: "Hall Greece", t: "Felipe"),
                                 Programa(h: "13:20-14:20", hl: "Hall Greece", t: "Felipe"),
                                 Programa(h: "14:30-15:30", hl: "", t: "")]
    
    let intHoursSn:[Programa] = [Programa(h: "11:00-12:00", hl: "Hall Italy", t: "Ryan & Evgenia"),
                                 Programa(h: "12:00-13:00", hl: "Hall Italy", t: "William & Maeva"),
                                 Programa(h: "13:10-14:10", hl: "", t: ""),
                                 Programa(h: "14:20-15:20", hl: "", t: ""),
                                 Programa(h: "15:30-16:30", hl: "", t: "")]
    
    // Intermidiate-Advance 1
    let intadv1HoursF:[Programa] = [Programa(h: "12:00-13:00", hl: "Hall Slovenia", t: "Audition"),
                                    Programa(h: "13:10-14:10", hl: "Hall Czech Republic", t: "William & Maeva"),
                                    Programa(h: "14:20-15:20", hl: "Hall Slovenia", t: "Alice"),
                                    Programa(h: "15:30-16:30", hl: "Hall Slovenia", t: "Alice")]
    
    let intadv1HoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                     Programa(h: "12:10-13:10", hl: "Hall Slovenia", t: "Ryan & Evgenia"),
                                     Programa(h: "13:20-14:20", hl: "Hall Bulgaria", t: "Max & Audrey"),
                                     Programa(h: "14:30-15:30", hl: "", t: "")]
    
    let intadv1HoursSn:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                     Programa(h: "12:00-13:00", hl: "Hall Bulgaria", t: "Felipe & Alice"),
                                     Programa(h: "13:10-14:10", hl: "Hall Bulgaria", t: "Ryan & Evgenia"),
                                     Programa(h: "14:20-15:20", hl: "", t: ""),
                                     Programa(h: "15:30-16:30", hl: "Hall Czech Republic", t: "William & Maeva")]
    
    // Intermidiate-Advance 2
    let intadv2HoursF:[Programa] = [Programa(h: "12:00-13:00", hl: "Hall Slovenia", t: "Audition"),
                                    Programa(h: "13:10-14:10", hl: "Hall Slovenia", t: "Ryan & Evgenia"),
                                    Programa(h: "14:20-15:20", hl: "Hall Slovenia", t: "Alice"),
                                    Programa(h: "15:30-16:30", hl: "Hall Slovenia", t: "Alice")]
    
    let intadv2HoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "Hall Greece", t: "Max & Audrey"),
                                     Programa(h: "12:10-13:10", hl: "Hall Slovenia", t: "Ryan & Evgenia"),
                                     Programa(h: "13:20-14:20", hl: "", t: ""),
                                     Programa(h: "14:30-15:30", hl: "Hall Czech Republic", t: "Max & Audrey")]
    
    let intadv2HoursSn:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                     Programa(h: "12:00-13:00", hl: "", t: ""),
                                     Programa(h: "13:10-14:10", hl: "", t: ""),
                                     Programa(h: "14:20-15:20", hl: "Hall Bulgaria", t: "William & Maeva"),
                                     Programa(h: "15:30-16:30", hl: "Hall Bulgaria", t: "Felipe & Alice")]
    
    // Advance
    let advHoursF:[Programa] = [Programa(h: "12:00-13:00", hl: "Hall Slovenia", t: "Audition"),
                                Programa(h: "13:10-14:10", hl: "Hall Greece", t: "Max & Audrey"),
                                Programa(h: "14:20-15:20", hl: "Hall Czech Republic", t: "William & Maeva"),
                                Programa(h: "15:30-16:30", hl: "Hall Czech Republic", t: "Ryan & Evgenia")]
    
    let advHoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                 Programa(h: "12:10-13:10", hl: "", t: ""),
                                 Programa(h: "13:20-14:20", hl: "Hall Slovenia", t: "Ryan & Evgenia"),
                                 Programa(h: "14:30-15:30", hl: "Hall Bulgaria", t: "William & Maeva")]
    
    let advHoursSn:[Programa] = [Programa(h: "11:00-12:00", hl: "Hall Bulgaria", t: "Felipe & Alice"),
                                 Programa(h: "12:00-13:00", hl: "Hall Romania", t: "Max"),
                                 Programa(h: "13:20-14:20", hl: "Hall Romania", t: "Max"),
                                 Programa(h: "14:20-15:20", hl: "", t: ""),
                                 Programa(h: "15:30-16:30", hl: "", t: "")]
    
    // Advance +
    let advpHoursF:[Programa] = [Programa(h: "12:00-13:00", hl: "Hall Slovenia", t: "Audition"),
                                 Programa(h: "13:10-14:10", hl: "", t: ""),
                                 Programa(h: "14:20-15:20", hl: "Hall Bulgaria", t: "Ryan & Evgenia"),
                                 Programa(h: "15:30-16:30", hl: "Hall Bulgaria", t: "William & Maeva")]
    
    let advpHoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "Hall Slovenia", t: "William & Maeva"),
                                  Programa(h: "12:10-13:10", hl: "Hall Slovenia", t: "Max & Audrey"),
                                  Programa(h: "13:20-14:20", hl: "Hall Slovenia", t: "Ryan & Evgenia"),
                                  Programa(h: "14:30-15:30", hl: "", t: "")]
    
    let advpHoursSn:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                  Programa(h: "12:00-13:00", hl: "Hall Romania", t: "Max"),
                                  Programa(h: "13:20-14:20", hl: "Hall Romania", t: "Max"),
                                  Programa(h: "14:20-15:20", hl: "Hall Romania", t: "Felipe & Alice"),
                                  Programa(h: "15:30-16:30", hl: "", t: "")]
    
    // Invitation
    let invHoursF:[Programa] = [Programa(h: "12:00-13:00", hl: "", t: ""),
                                Programa(h: "13:10-14:10", hl: "", t: ""),
                                Programa(h: "14:20-15:20", hl: "", t: ""),
                                Programa(h: "15:30-16:30", hl: "", t: "")]
    
    let invHoursSt:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                Programa(h: "12:10-13:10", hl: "Hall Czech Republic", t: "William & Maeva"),
                                Programa(h: "13:20-14:20", hl: "Hall Czech Republic", t: "William & Maeva"),
                                Programa(h: "14:30-15:30", hl: "Hall Slovenia", t: "Felipe & Alice")]
    
    let invHoursSn:[Programa] = [Programa(h: "11:00-12:00", hl: "", t: ""),
                                Programa(h: "12:00-13:00", hl: "Hall Czech Republic", t: "Ryan & Evgenia"),
                                Programa(h: "13:20-14:20", hl: "Hall Czech Republic", t: "Felipe & Alice"),
                                Programa(h: "14:20-15:20", hl: "Hall Czech Republic", t: "Max & Audrey"),
                                Programa(h: "15:30-16:30", hl: "", t: "")]
    
    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.tableFooterView = UIView()
        
        switch type {
        case "others":
            title = "Parties and Collective activities"
            break
        case "tasters":
            title = "Tasters"
            break
        case "int":
            title = "Intermediate"
            break
        case "int-adv1":
            title = "Intermediate-Advance 1"
            break
        case "int-adv2":
            title = "Intermediate-Advance 2"
            break
        case "adv":
            title = "Advance"
            break
        case "adv+":
            title = "Advance+"
            break
        case "inv":
            title = "Invitation"
            break
        case "tasters":
            title = "Tasters"
            break
            
        default:
            break
        }
    }

    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        if (type == "others") {
            return sections.count
        }
        
        return sections.count-1
    }

    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        switch type {
        case "others":
            if (section == 0) {return othersHoursT.count}
            if (section == 1) {return othersHoursF.count}
            if (section == 2) {return othersHoursSt.count}
            if (section == 3) {return othersHoursSn.count}
            break
        case "tasters":
            if (section == 0) {return tastersHoursT.count}
            if (section == 1) {return tastersHoursF.count}
            if (section == 2) {return tastersHoursSt.count}
            break
        default:
            if (section == 0) {return intHoursF.count}
            if (section == 1) {return intHoursSt.count}
            if (section == 2) {return intHoursSn.count}
            break
        }
        
        return 0
    }

    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:ProgaramaPageTableViewCell = tableView.dequeueReusableCellWithIdentifier("reuseIdentifier", forIndexPath: indexPath) as! ProgaramaPageTableViewCell

        var pg:Programa = Programa()
        switch type {
        case "others":
            if (indexPath.section == 0) {pg = othersHoursT[indexPath.row]}
            if (indexPath.section == 1) {pg = othersHoursF[indexPath.row]}
            if (indexPath.section == 2) {pg = othersHoursSt[indexPath.row]}
            if (indexPath.section == 3) {pg = othersHoursSn[indexPath.row]}
            break
        case "int":
            if (indexPath.section == 0) {pg = intHoursF[indexPath.row]}
            if (indexPath.section == 1) {pg = intHoursSt[indexPath.row]}
            if (indexPath.section == 2) {pg = intHoursSn[indexPath.row]}
            break
        case "int-adv1":
            if (indexPath.section == 0) {pg = intadv1HoursF[indexPath.row]}
            if (indexPath.section == 1) {pg = intadv1HoursSt[indexPath.row]}
            if (indexPath.section == 2) {pg = intadv1HoursSn[indexPath.row]}
            break
        case "int-adv2":
            if (indexPath.section == 0) {pg = intadv2HoursF[indexPath.row]}
            if (indexPath.section == 1) {pg = intadv2HoursSt[indexPath.row]}
            if (indexPath.section == 2) {pg = intadv2HoursSn[indexPath.row]}
            break
        case "adv":
            if (indexPath.section == 0) {pg = advHoursF[indexPath.row]}
            if (indexPath.section == 1) {pg = advHoursSt[indexPath.row]}
            if (indexPath.section == 2) {pg = advHoursSn[indexPath.row]}
            break
        case "adv+":
            if (indexPath.section == 0) {pg = advpHoursF[indexPath.row]}
            if (indexPath.section == 1) {pg = advpHoursSt[indexPath.row]}
            if (indexPath.section == 2) {pg = advpHoursSn[indexPath.row]}
            break
        case "inv":
            if (indexPath.section == 0) {pg = invHoursF[indexPath.row]}
            if (indexPath.section == 1) {pg = invHoursSt[indexPath.row]}
            if (indexPath.section == 2) {pg = invHoursSn[indexPath.row]}
            break
        case "tasters":
            if (indexPath.section == 0) {pg = tastersHoursT[indexPath.row]}
            if (indexPath.section == 1) {pg = tastersHoursF[indexPath.row]}
            if (indexPath.section == 2) {pg = tastersHoursSt[indexPath.row]}
            cell.titleLabel?.font = UIFont.systemFontOfSize(15)
            break
            
        default:
            break
        }

        cell.titleLabel?.text = pg.title
        cell.hourLabel?.text = pg.hour
        cell.hallLabel?.text = pg.hall
        cell.hallLabel?.backgroundColor = UIColor.whiteColor()
        if (pg.hall == "Hall Bulgaria") {
            cell.hallLabel?.backgroundColor = UIColor(red: 1, green: 1, blue: 0, alpha: 1.0)
        }
        if (pg.hall == "Hall Czech Republic") {
            cell.hallLabel?.backgroundColor = UIColor(red: 1, green: 0.75, blue: 0, alpha: 1.0)
        }
        if (pg.hall == "Hall Romania") {
            cell.hallLabel?.backgroundColor = UIColor(red: 0.57, green: 0.82, blue: 0.31, alpha: 1.0)
        }
        if (pg.hall == "Hall Italy") {
            cell.hallLabel?.backgroundColor = UIColor(red: 0.44, green: 0.67, blue: 0.27, alpha: 1.0)
        }
        if (pg.hall == "Hall Greece") {
            cell.hallLabel?.backgroundColor = UIColor(red: 0.18, green: 0.46, blue: 0.71, alpha: 1.0)
        }
        if (pg.hall == "Hall Slovenia") {
            cell.hallLabel?.backgroundColor = UIColor(red: 0.73, green: 0.84, blue: 0.93, alpha: 1.0)
        }
        
        
        return cell
    }
 

    override func tableView(tableView: UITableView,
                            heightForHeaderInSection section: Int) -> CGFloat{
        return 30
    }
    
    override func tableView(tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int)
    {
        let header = view as! UITableViewHeaderFooterView
        header.textLabel?.textColor = UIColor.lightGrayColor()
        if (type == "others" || type == "tasters") {
            header.textLabel?.text = sections[section]
        }
        else {
            header.textLabel?.text = sections[section+1]
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
