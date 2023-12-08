import { GitHub, Twitter } from "@material-ui/icons";
import React from "react";
import FooterCSS from "./Footer.module.css";

const Footer = () => {
  return (
    <div className={FooterCSS.Footer}>
      <div className={FooterCSS.footercontainer}>
        <h1>BlackSlate | 2023</h1>
        <div className={FooterCSS.icons}>
          {" "}
          <a
            href="https://twitter.com/blackslate"
            target="_blank"
            rel="noreferrer"
          >
            <Twitter className={FooterCSS.icon} />
          </a>
          <a href="https://github.com/blackslate-samples/" target="_blank" rel="noreferrer">
            <GitHub className={FooterCSS.icon} />
          </a>
        </div>
      </div>
    </div>
  );
};

export default Footer;