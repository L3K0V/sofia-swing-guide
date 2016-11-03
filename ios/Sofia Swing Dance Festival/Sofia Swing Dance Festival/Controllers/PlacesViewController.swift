//
//  PlacesViewController.swift
//  Sofia Swing Dance Festival
//
//  Created by Slav Sarafski on 5/18/16.
//  Copyright © 2016 Spirit Invoker. All rights reserved.
//

import UIKit
import GoogleMaps
import AFOAuth2Manager

class PlacesViewController: UIViewController, CLLocationManagerDelegate, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var mapView: GMSMapView!
    @IBOutlet weak var talbeView: UITableView!
    var locationManager = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()

//        let iv:UIImageView = UIImageView (image: UIImage(named: "Logo"))
//        iv.frame.size.width = 40
//        iv.frame.size.height = 40
//        iv.contentMode = .ScaleAspectFit
//        self.navigationItem.titleView = iv
        
        self.navigationItem.title = "Swing Aout"
        
        let camera = GMSCameraPosition.camera(withLatitude: 44.9677325, longitude: 2.1883318, zoom: 15)
        mapView.camera = camera
        mapView.settings.myLocationButton = true
        mapView.isMyLocationEnabled = true
        
        locationManager.delegate = self;
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        locationManager.requestWhenInUseAuthorization()
        locationManager.startUpdatingLocation()
        
        loadLocations()
    }
    
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        if status == CLAuthorizationStatus.authorizedWhenInUse {
            mapView.isMyLocationEnabled = true
            mapView.settings.myLocationButton = true
        }
    }
    
    var markers:[GMSMarker] = []
    func createMarkers () {
        markers = []
        for loc in locations {
            let position = CLLocationCoordinate2DMake(loc.lat, loc.lon)
            let marker = GMSMarker(position: position)
            marker.title = loc.title
            marker.snippet = loc.text
            marker.map = mapView
            markers.append(marker)
        }
        
    }
    
    var locations:[Location] = []
    let baseURL = URL(string: "http://swingaout.lekov.me")
    func loadLocations () {
        let manager:AFHTTPSessionManager = AFHTTPSessionManager(baseURL: baseURL)
        manager.requestSerializer.setAuthorizationHeaderFieldWith(AFOAuthCredential.retrieveCredential(withIdentifier: "credential"))
        manager.requestSerializer.setValue("application/json", forHTTPHeaderField: "Accept")
        manager.requestSerializer.setValue("application/json", forHTTPHeaderField: "Content-Type")
        
        manager.get("/events/1/guide/",
                    parameters: nil,
                    progress: { (pro) in
                        
            }, success: { (task, res) in
                let json = JSON(res!)
                                print("daaa \(json)")
                for (_, item) in json["features"] {
                    self.locations.append(Location (item: item))
                }
                self.createMarkers()
                self.talbeView.reloadData()
        }) { (task, error) in
            print ("neee \(error)")
        }
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return locations.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell:LocationCellTableViewCell = tableView.dequeueReusableCell(withIdentifier: "locationsIdentifier", for: indexPath) as! LocationCellTableViewCell
        
        cell.titleLabel!.text = locations[(indexPath as NSIndexPath).row].title
        cell.descrionLabel!.text = locations[(indexPath as NSIndexPath).row].text
        cell.button!.tag = (indexPath as NSIndexPath).row
        cell.button!.addTarget(self, action: #selector(gotoGoogleMap(_:)), for: .touchUpInside)
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let camera = GMSCameraPosition.camera(withLatitude: locations[(indexPath as NSIndexPath).row].lat, longitude: locations[(indexPath as NSIndexPath).row].lon, zoom: mapView.camera.zoom)
        mapView.camera = camera
        mapView.selectedMarker = markers[(indexPath as NSIndexPath).row]
    }
    
    func gotoGoogleMap(_ sender: AnyObject) {
        if (UIApplication.shared.canOpenURL(URL(string:"comgooglemaps://")!)) {
            if let navAdd = URL(string:"comgooglemaps://?saddr=Current+Location&daddr=\(locations[sender.tag].lat),\(locations[sender.tag].lon)&directionsmode=walking") {
                UIApplication.shared.openURL(navAdd)
            }
//            print ("loc \(locations[sender.tag].lon)")
//            UIApplication.sharedApplication().openURL(NSURL(string:"google.com")!)
        } else {
            print("Can't use comgooglemaps://");
        }

    }
}
